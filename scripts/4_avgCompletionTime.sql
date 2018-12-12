create or replace function avgCompletionTime(date, date)
 RETURNS TABLE (
 service_request_type varchar,
 avg_days_to_complete numeric
) 
AS $$
select incident.service_request_type, round(AVG(incident.completion_date - incident.creation_date), 2) as days_to_complete from incident
where incident.creation_date >= $1 and incident.completion_date <= $2
group by incident.service_request_type
$$
LANGUAGE 'sql';
