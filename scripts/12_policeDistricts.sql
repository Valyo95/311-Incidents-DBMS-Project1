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