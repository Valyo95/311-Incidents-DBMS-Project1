drop function if exists totalRequestsPerType;
create function totalRequestsPerType(timestamp , timestamp )
 RETURNS TABLE (
 service_request_type VARCHAR,
 incidents bigINT
) 
AS $$

 select service_request_type, count(id) as incidents from incident
 where creation_date between $1 and $2
 group by service_request_type
 order by incidents desc
 $$ 
LANGUAGE 'sql';