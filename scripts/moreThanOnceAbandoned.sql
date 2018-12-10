create or replace function moreThanOnceAbandoned()
 RETURNS TABLE (
 license_plate varchar,
 incidents bigint
) 
AS $$
select license_plate,count(abandoned_vehicles.srn) from incident
join abandoned_vehicles 
ON abandoned_vehicles.srn = incident.srn
where incident.service_request_type = 'ABANDONED_VEHICLES'
GROUP by abandoned_vehicles.license_plate
having count(abandoned_vehicles.srn)  > 1
$$
LANGUAGE 'sql';
