
create or replace function rodentBaitingWithPremisesBaitedLessThan(int)
 RETURNS TABLE (
 id int
) 
AS $$
select rodent_baiting.id from rodent_baiting
where rodent_baiting.premises_baited < $1
$$
LANGUAGE 'sql';