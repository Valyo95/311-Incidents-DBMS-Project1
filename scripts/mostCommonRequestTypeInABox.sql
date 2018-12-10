create or replace function mostCommonRequestTypeInABox(int, int, int, int, date)
 RETURNS TABLE (
 service_request_type varchar,
 incidents bigint
) 
AS $$

select service_request_type, count(srn) as incindents 
from incident
	where latitude between $1 and $2
	and longitude between $3 and $4
	and creation_date = $5
group by service_request_type
order by incindents desc
limit 1
$$
LANGUAGE 'sql';
