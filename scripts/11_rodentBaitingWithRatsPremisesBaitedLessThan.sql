create or replace function rodentBaitingWithRatsPremisesBaitedLessThan(int)
 RETURNS TABLE (
 id int
) 
AS $$
select rodent_baiting.id from rodent_baiting
where premises_with_rats < $1
$$
LANGUAGE 'sql';