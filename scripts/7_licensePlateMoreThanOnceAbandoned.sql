create or replace function moreThanOnceAbandoned()
 RETURNS TABLE (
 license_plate varchar,
 incidents bigint
) 
AS $$
select license_plate,count(id) from abandoned_vehicles
GROUP by abandoned_vehicles.license_plate
having count(abandoned_vehicles.id)  > 1
$$
LANGUAGE 'sql';

