package com.Game.Game.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.Game.Game.dataStorage.BonusData;
import com.Game.Game.functions.FindEntityInfo;
import com.Game.Game.modelsDB.Bonus;
import com.Game.Game.modelsDB.NPC;

import junit.framework.TestCase;

import java.util.ArrayList;

public class FindEntityInfoTest extends TestCase {

    private ArrayList<Object> objs;
    private ArrayList<NPC> npcs;
    private ArrayList<Bonus> bonus;

    private static final String OBJECT= "object";
    private static final String NPC = "npc";
    private static final String BONUS = "bonus";
    private static final String OTHER = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //must first initialize them
        //objs = ObjectsData.getObjects();
        //npcs = NpcsData.getNPCs();
        //bonus = BonusData.getBonuses();
    }

    @SmallTest
    public void testShouldNotBeNull () {
        assertNotNull(objs);
        assertNotNull(npcs);
        assertNotNull(bonus);
    }

    @SmallTest
    public void testFindEntityID () {

        int expected;
        int result;
        int id = 3;

        //FOR OBJECT -> (3, receipt)
        expected = objs.get(id).getObjId();
        result = FindEntityInfo.findID("receipt");
        assertEquals(expected, result);

        //FOR NPC -> (3, waiter)
        expected = npcs.get(id).getNPCId();
        result = FindEntityInfo.findID("waiter");
        assertEquals(expected, result);

        //FOR BONUS -> (3, bonusD)
        expected = bonus.get(id).getId();
        result = FindEntityInfo.findID("bonusD");
        assertEquals(expected, result);

        //FOR other -> default = 1
        expected = -1;
        result = FindEntityInfo.findID("other");
        assertEquals(expected, result);

    }

    @SmallTest
    public void testFindEntityType () {

        String expected;
        String result;
        int id = 3;

        //FOR OBJECT -> (3, receipt)
        expected = OBJECT;
        result = FindEntityInfo.findType("receipt");
        assertEquals(expected, result);

        //FOR NPC -> (3, waiter)
        expected = NPC;
        result = FindEntityInfo.findType("waiter");
        assertEquals(expected, result);

        //FOR BONUS -> (3, bonusD)
        expected = BONUS;
        result = FindEntityInfo.findType("bonusD");
        assertEquals(expected, result);

        //FOR other -> default = 1
        expected = null;
        result = FindEntityInfo.findType("other");
        assertEquals(expected, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
