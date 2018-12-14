CREATE OR REPLACE FUNCTION import_data_from_csv_tables()
RETURNS VOID AS $$
DECLARE
    x RECORD;
	next_incident_id integer;
BEGIN

-- abandoned vehicles
FOR x IN SELECT * FROM abandoned_vehicles_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'ABANDONED_VEHICLES',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO abandoned_vehicles
SELECT
  nextval('abandoned_vehicles_id_seq'),
  x.vehicle_color,
  x.current_activity,
  x.days,
  x.license_plate,
  x.model,
  x.most_recent_action,
  x.ssa,
  next_incident_id;

END LOOP;

-- alley lights out
FOR x IN SELECT * FROM alley_lights_out_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'ALLEY_LIGHTS_OUT',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO alley_lights_out
SELECT
  nextval('alley_lights_out_id_seq'),
  next_incident_id;

END LOOP;

-- garbage carts
FOR x IN SELECT * FROM garbage_carts_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'GARBAGE_CARTS',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO garbage_carts
SELECT
  nextval('garbage_carts_id_seq'),
  x.black_carts_delivered,
  x.Current_Activity,
  x.Most_Recent_Action,
  x.ssa,
  next_incident_id;

END LOOP;

-- graffiti removal
FOR x IN SELECT * FROM graffiti_removal_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'GRAFFITI_REMOVAL',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO graffiti_removal
SELECT
  nextval('graffiti_removal_id_seq'),
  x.graffiti_location,
  x.ssa,
  x.surface_type,
  next_incident_id;

END LOOP;

-- lights all out
FOR x IN SELECT * FROM lights_all_out_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'LIGHTS_ALL_OUT',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO lights_all_out
SELECT
  nextval('lights_all_out_id_seq'),
  next_incident_id;

END LOOP;

-- lights one out
FOR x IN SELECT * FROM lights_one_out_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'STREET_LIGHT_ONE_OUT',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO lights_one_out
SELECT
  nextval('lights_one_out_id_seq'),
  next_incident_id;

END LOOP;

-- pot hols
FOR x IN SELECT * FROM pot_hols_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'POT_HOLES_REPORTED',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO pot_hols
SELECT
  nextval('pot_hols_id_seq'),
  x.Current_Activity,
  x.Most_Recent_Action,
  x.pot_holes,
  x.ssa,
  next_incident_id;

END LOOP;

-- rodent baiting
FOR x IN SELECT * FROM rodent_baiting_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'RODENT_BAITING',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO rodent_baiting
SELECT
  nextval('rodent_baiting_id_seq'),
  x.Current_Activity,
  x.Most_Recent_Action,
  x.baited_premises,
  x.garbage_premises,
  x.rat_premises,
  next_incident_id;

END LOOP;

-- sanitation code complaints
FOR x IN SELECT * FROM sanitation_code_complaints_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'SANITATION_CODE_COMPLAINTS',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO sanitation_code_complaints
SELECT
  nextval('sanitation_code_complaints_id_seq'),
  x.nature_of_violation,
  next_incident_id;

END LOOP;


-- tree debris
FOR x IN SELECT * FROM tree_debris_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'TREE_DEBRIS',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO tree_debris
SELECT
  nextval('tree_debris_id_seq'),
  x.Current_Activity,
  x.debris_location,
  x.Most_Recent_Action,
  next_incident_id;

END LOOP;

-- tree trims
FOR x IN SELECT * FROM tree_trims_import
LOOP

next_incident_id = nextval('incident_id_seq');

INSERT INTO incident
SELECT
	next_incident_id,
	x.Community_Area,
	x.Completion_Date,
	x.Creation_Date,
	x.Latitude,
	x.Location,
	x.Longitude,
	x.Police_District,
	x.Status,
	x.Street_Address,
	x.Service_Request_Number,
	'TREE_TRIMS',
	x.Ward,
	x.X_Coordinate,
	x.Y_Coordinate,
	x.ZIP_Code;

INSERT INTO tree_trims
SELECT
  nextval('tree_trims_id_seq'),
  x.trees_location,
  next_incident_id;

END LOOP;

END;
$$ LANGUAGE plpgsql;

select import_data_from_csv_tables();