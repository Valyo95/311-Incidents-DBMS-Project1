package com.incidents.enumerations;

public enum TypeOfServiceRequest {
	ABANDONED_VEHICLES(1),
	ALLEY_LIGHTS_OUT(2),
	GARBAGE_CARTS(3),
	GRAFFITI_REMOVAL(4),
	POT_HOLES_REPORTED(5),
	RODENT_BAITING(6),
	SANITATION_CODE_COMPLAINTS(7),
	LIGHTS_ALL_OUT(8),
	STREET_LIGHT_ONE_OUT(9),
	TREE_DEBRIS(10),
	TREE_TRIMS(11);

    private final int type;

    private TypeOfServiceRequest(int type)
    {
        this.type = type;
    }

    public int TypeOfServiceRequest()
    {
        return type;
    }
}
