not ready yet.
lsdgfjsdsdgs

create or replace function secondCommonColor()
 RETURNS TABLE (
 license_plate varchar,
 incidents bigint
) 
AS $$

select abandoned_vehicles.color, count(abandoned_vehicles.srn) as vehicles from incident
join abandoned_vehicles 
ON abandoned_vehicles.srn = incident.srn
where incident.service_request_type = 'ABANDONED_VEHICLES'
GROUP by abandoned_vehicles.color
order by vehicles desc
limit 2
$$
LANGUAGE 'sql';
