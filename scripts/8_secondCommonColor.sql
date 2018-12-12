create or replace function secondCommonColor()
 RETURNS TABLE (
 color varchar,
 incidents bigint
) 
AS $$
select abandoned_vehicles.color, count(id) as vehicles from  abandoned_vehicles 
GROUP by abandoned_vehicles.color
order by vehicles desc
limit 1 offset 1
$$
LANGUAGE 'sql';
