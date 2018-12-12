
drop function if exists totalRequestsPerDay;
create function totalRequestsPerDay(varchar,timestamp , timestamp )
 RETURNS TABLE (
 "day" date,
 incidents bigINT
) 
AS $$
select date(creation_date) as per_day, count(id) from incident
where service_request_type = $1
and creation_date between $2 and $3
group by per_day
 $$ 
LANGUAGE 'sql';

