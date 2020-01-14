package com.LTreu.Swingy.facts;

import com.LTreu.Swingy.mods.artefacts.Artefact;

public class ArtefactFactory
{
    private static int id = 0;

    public static Artefact newArtefact(int value, String type)
    {
        id++;

        Artefact artefact = new Artefact(type +"_"+id,type,value, id);
        return (artefact);
    }

    public static Artefact oldArtefact(int id, int value, String name, String type)
    {
        Artefact artefact = new Artefact(name,type,value, id);
        return (artefact);
    }
}
