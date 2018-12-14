DROP TABLE IF EXISTS abandoned_vehicles_import;
CREATE TABLE IF NOT EXISTS abandoned_vehicles_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
License_Plate text,
Model text,
Vehicle_Color text,
Current_Activity text,
Most_Recent_Action text,
days double precision,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
SSA text,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS alley_lights_out_import;
CREATE TABLE IF NOT EXISTS alley_lights_out_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS garbage_carts_import;
CREATE TABLE IF NOT EXISTS garbage_carts_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
black_carts_delivered double precision,
Current_Activity text,
Most_Recent_Action text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
SSA text,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS graffiti_removal_import;
CREATE TABLE IF NOT EXISTS graffiti_removal_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
surface_type text,
graffiti_location text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
SSA text,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS lights_all_out_import;
CREATE TABLE IF NOT EXISTS lights_all_out_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS lights_all_out_import;
CREATE TABLE IF NOT EXISTS lights_all_out_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS lights_one_out_import;
CREATE TABLE IF NOT EXISTS lights_one_out_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS pot_hols_import;
CREATE TABLE IF NOT EXISTS pot_hols_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
Current_Activity text,
Most_Recent_Action text,
pot_holes double precision,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
SSA text,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS rodent_baiting_import;
CREATE TABLE IF NOT EXISTS rodent_baiting_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
baited_premises double precision,
garbage_premises double precision,
rat_premises double precision,
Current_Activity text,
Most_Recent_Action text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS sanitation_code_complaints_import;
CREATE TABLE IF NOT EXISTS sanitation_code_complaints_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
nature_of_violation text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS tree_debris_import;
CREATE TABLE IF NOT EXISTS tree_debris_import
(
Creation_Date timestamp,
Status text,
Completion_Date timestamp,
Service_Request_Number text,
Type_of_Service_Request text,
debris_location text,
Current_Activity text,
Most_Recent_Action text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);

DROP TABLE IF EXISTS tree_trims_import;
CREATE TABLE IF NOT EXISTS tree_trims_import
(
Creation_Date timestamp,
Status text,
Completion_Date timesta	mp,
Service_Request_Number text,
Type_of_Service_Request text,
trees_location text,
Street_Address text,
ZIP_Code text,
X_Coordinate double precision,
Y_Coordinate double precision,
Ward integer,
Police_District integer,
Community_Area integer,
Latitude double precision,
Longitude double precision,
Location text
);
