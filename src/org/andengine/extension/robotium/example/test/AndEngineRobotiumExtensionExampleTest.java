package org.andengine.extension.robotium.example.test;

import junit.framework.Assert;

import org.anddev.andengine.entity.sprite.Sprite;
import org.andengine.extension.robotium.AndEngineSolo;
import org.andengine.extension.robotium.example.AndEngineRobotiumExtensionExample;
import org.andengine.extension.robotium.example.RobotiumDebugTags;

import android.test.ActivityInstrumentationTestCase2;


/**
 * (c) Zynga 2012
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 15:08:53 - 14.02.2012
 */
public class AndEngineRobotiumExtensionExampleTest extends ActivityInstrumentationTestCase2<AndEngineRobotiumExtensionExample> implements RobotiumDebugTags {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private AndEngineSolo mAndEngineSolo;

	// ===========================================================
	// Constructors
	// ===========================================================

	public AndEngineRobotiumExtensionExampleTest() {
		super("org.andengine.extension.robotium.example", AndEngineRobotiumExtensionExample.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.mAndEngineSolo = new AndEngineSolo(this.getInstrumentation(), this.getActivity());
	}

	@Override
	protected void tearDown() throws Exception {
		this.mAndEngineSolo.finishOpenedActivities();

		super.tearDown();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public void testDisplayBlackBox() {
		/* Enter 10 in first edittext. */
		this.mAndEngineSolo.enterText(0, "10");

		/* Enter 20 in first edittext. */
		this.mAndEngineSolo.enterText(1, "20");

		/* Click on Multiply button. */
		this.mAndEngineSolo.clickOnButton("Multiply");

		/* Verify result is 200. */
		Assert.assertTrue(this.mAndEngineSolo.searchText("200"));

		/* AndEngine specific tests. */
		this.mAndEngineSolo.clickOnEntity(Sprite.class, RobotiumDebugTags.ROBOTIUM_TAG_BOX);

		this.mAndEngineSolo.sleep(100);

		Assert.assertFalse(this.mAndEngineSolo.isEntityVisible(Sprite.class, RobotiumDebugTags.ROBOTIUM_TAG_BOX));
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}