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

create or replace function mostCommonRequestTypeInABox(int, int, int, int, date)
 RETURNS TABLE (
 service_request_type varchar,
 incidents bigint
) 
AS $$

select service_request_type, count(id) as incindents 
from incident
	where latitude between $1 and $2
	and longitude between $3 and $4
	and creation_date = $5
group by service_request_type
order by incindents desc
limit 1
$$
LANGUAGE 'sql';

create or replace function topFiveSSA(date, date)
 RETURNS TABLE (
 ssa varchar,
 incidents bigint
) 
AS $$
select ssa, count(id) as times from(
	select incident.*, ssa from incident
	join abandoned_vehicles ON abandoned_vehicles.incident_id = incident.id
		where creation_date between $1 and $2
	union
	select incident.*, ssa from incident
	join garbage_carts ON garbage_carts.incident_id = incident.id
		where creation_date between $1 and $2
	union
	select incident.*, ssa from incident
	join graffiti_removal ON graffiti_removal.incident_id = incident.id
		where creation_date between $1 and $2
	union
	select incident.*, ssa from incident
	join pot_hols ON pot_hols.incident_id = incident.id
		where creation_date between $1 and $2
) ssas
group by ssa
order by times desc
limit 5
$$
LANGUAGE 'sql';

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


create or replace function rodentBaitingWithPremisesBaitedLessThan(int)
 RETURNS TABLE (
 id int
) 
AS $$
select rodent_baiting.id from rodent_baiting
where rodent_baiting.premises_baited < $1
$$
LANGUAGE 'sql';

create or replace function rodentBaitingWithGarbagePremisesBaitedLessThan(int)
 RETURNS TABLE (
 id int
) 
AS $$
select rodent_baiting.id from rodent_baiting
where premises_with_garbage < $1
$$
LANGUAGE 'sql';

create or replace function rodentBaitingWithRatsPremisesBaitedLessThan(int)
 RETURNS TABLE (
 id int
) 
AS $$
select rodent_baiting.id from rodent_baiting
where premises_with_rats < $1
$$
LANGUAGE 'sql';

create or replace function policeDistricts()
 RETURNS TABLE (
 police_district int
) 
AS $$
	SELECT distinct  police_district
	FROM incident incA
	JOIN pot_hols ON pot_hols.incident_id = incA.id
	WHERE pot_hols.pot_hols > 1
	AND EXISTS (
	  SELECT *
	  FROM incident incB
	  JOIN rodent_baiting ON rodent_baiting.incident_id = incB.id
	  WHERE incB.completion_date = incA.completion_date
	  AND rodent_baiting.premises_baited > 1
	)
$$
LANGUAGE 'sql';