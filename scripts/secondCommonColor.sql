create or replace function secondCommonColor()
 RETURNS TABLE (
 color varchar,
 incidents bigint
) 
AS $$
select abandoned_vehicles.color, count(abandoned_vehicles.srn) as vehicles from incident
join abandoned_vehicles 
ON abandoned_vehicles.srn = incident.srn
where incident.service_request_type = 'ABANDONED_VEHICLES'
GROUP by abandoned_vehicles.color
order by vehicles desc
limit 1 offset 1

$$
LANGUAGE 'sql';
