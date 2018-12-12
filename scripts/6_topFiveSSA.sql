create or replace function topFiveSSA(date, date)
 RETURNS TABLE (
 ssa varchar,
 incidents bigint
) 
AS $$
select ssa, count(srn) as times from(
select incident.*, ssa from incident
join abandoned_vehicles ON abandoned_vehicles.srn = incident.srn
where creation_date between $1 and $2
union
select incident.*, ssa from incident
join garbage_carts ON garbage_carts.srn = incident.srn
where creation_date between $1 and $2
union
select incident.*, ssa from incident
join graffiti_removal ON graffiti_removal.srn = incident.srn
where creation_date between $1 and $2
union
select incident.*, ssa from incident
join pot_hols ON pot_hols.srn = incident.srn
where creation_date between $1 and $2
) ssas
group by ssa
order by times desc
limit 5
$$
LANGUAGE 'sql';
