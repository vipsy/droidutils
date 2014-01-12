package com.selesca.droidutils.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.content.Context;

import com.selesca.droidutils.BasePreferences;

@RunWith(RobolectricTestRunner.class)
public class BasePreferencesTest {
	
	private BasePreferences mPref;
	private Context mContext;
	
	@Before
	public void setup() {
		mContext = Robolectric.getShadowApplication().getApplicationContext();
		mPref = BasePreferences.getInstance(mContext);
	}
	
	@After
	public void tearDown() {
		//Clear all shared preferences.
		mPref.getSharedPreferences(mContext).edit().clear().commit();
	}
	
	@Test
	public void testIntPreference_StoreOne() {
		mPref.setInt("intOne", 1, mContext);
		int res = mPref.getInt("intOne", 0, mContext);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void testIntPreference_StoreZero() {
		mPref.setInt("intZero", 0, mContext);
		int res = mPref.getInt("intZero", -1, mContext);
		Assert.assertEquals(0, res);
	}
	
	@Test
	public void testIntPreference_StoreMax() {
		mPref.setInt("intMax", Integer.MAX_VALUE, mContext);
		int res = mPref.getInt("intMax", -1, mContext);
		Assert.assertEquals(Integer.MAX_VALUE, res);
	}

	@Test
	public void testIntPreference_StoreMin() {
		mPref.setInt("intMin", Integer.MIN_VALUE, mContext);
		int res = mPref.getInt("intMin", -1, mContext);
		Assert.assertEquals(Integer.MIN_VALUE, res);
	}
	
	@Test
	public void testThatMustFail() {
		Assert.assertEquals(1, 0);
	}

}
