create or replace function rodentBaitingWithGarbagePremisesBaitedLessThan(int)
 RETURNS TABLE (
 id int
) 
AS $$
select rodent_baiting.id from rodent_baiting
where premises_with_garbage < $1
$$
LANGUAGE 'sql';