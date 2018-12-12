
drop function if exists mostCommonServicePerZipCode;
create function mostCommonServicePerZipCode(date)
 RETURNS TABLE (
 zipcode varchar,
 service_request_type varchar,
 incidents bigint
) 
AS $$
select * from (
	select zip_code, service_request_type as srt, count(id) as incidents  from incident
	where creation_date = $1
	group by zip_code, service_request_type
)	as alll
where (zip_code, incidents) in (	
	select zip_code, max(incidents) from(
		select zip_code, service_request_type as srt, count(id) as incidents  from incident
		where creation_date = $1
		group by zip_code, service_request_type
	) as zip_requests
	group by zip_code)
 $$ 
LANGUAGE 'sql';

