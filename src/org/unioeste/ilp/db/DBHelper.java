/*
 * "Copyright 2012 Lucas Andr� de Alencar"
 * 
 * This file is part of "Intelligent Lock Pattern".
 * 
 * "Intelligent Lock Pattern" is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * "Intelligent Lock Pattern" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License 
 * along with "Intelligent Lock Pattern".  If not, see <http://www.gnu.org/licenses/>.
 */

package org.unioeste.ilp.db;

import org.unioeste.ilp.models.DaoMaster;
import org.unioeste.ilp.models.DaoSession;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Responsible for establishing a session with the database. 
 * 
 * @author Lucas Andr� de Alencar
 *
 */
public class DBHelper {

	private static final String TAG = "DBHelper";
	public static final String DB_NAME = "ilp.db";
	
	final DaoMaster.DevOpenHelper helper;
	
	public DBHelper (Context context) {
		helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
		Log.i(TAG, "DBHelper created.");
	}
	
	public DaoSession getDaoSession () {
		SQLiteDatabase db = helper.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		DaoSession daoSession = daoMaster.newSession();
		return daoSession;
	}
	
	public void close() {
		helper.close();
	}
	
}
