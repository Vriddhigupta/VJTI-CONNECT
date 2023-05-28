package cgpakoto.com.cgpa;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class CgpaDatabase_Impl extends CgpaDatabase {
  private volatile CourseDao _courseDao;

  private volatile SemisterDao _semisterDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(6) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Course` (`credit` REAL, `gpa` REAL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `semister_name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Semister` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cgpa` REAL NOT NULL, `totalcredit` REAL NOT NULL, `semister_name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"154c05965a5dd181e7773c6e89efcb77\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Course`");
        _db.execSQL("DROP TABLE IF EXISTS `Semister`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCourse = new HashMap<String, TableInfo.Column>(4);
        _columnsCourse.put("credit", new TableInfo.Column("credit", "REAL", false, 0));
        _columnsCourse.put("gpa", new TableInfo.Column("gpa", "REAL", false, 0));
        _columnsCourse.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsCourse.put("semister_name", new TableInfo.Column("semister_name", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCourse = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCourse = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCourse = new TableInfo("Course", _columnsCourse, _foreignKeysCourse, _indicesCourse);
        final TableInfo _existingCourse = TableInfo.read(_db, "Course");
        if (! _infoCourse.equals(_existingCourse)) {
          throw new IllegalStateException("Migration didn't properly handle Course(cgpakoto.com.cgpa.Course).\n"
                  + " Expected:\n" + _infoCourse + "\n"
                  + " Found:\n" + _existingCourse);
        }
        final HashMap<String, TableInfo.Column> _columnsSemister = new HashMap<String, TableInfo.Column>(4);
        _columnsSemister.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsSemister.put("cgpa", new TableInfo.Column("cgpa", "REAL", true, 0));
        _columnsSemister.put("totalcredit", new TableInfo.Column("totalcredit", "REAL", true, 0));
        _columnsSemister.put("semister_name", new TableInfo.Column("semister_name", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSemister = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSemister = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSemister = new TableInfo("Semister", _columnsSemister, _foreignKeysSemister, _indicesSemister);
        final TableInfo _existingSemister = TableInfo.read(_db, "Semister");
        if (! _infoSemister.equals(_existingSemister)) {
          throw new IllegalStateException("Migration didn't properly handle Semister(cgpakoto.com.cgpa.Semister).\n"
                  + " Expected:\n" + _infoSemister + "\n"
                  + " Found:\n" + _existingSemister);
        }
      }
    }, "154c05965a5dd181e7773c6e89efcb77", "70c730930117c5f2dede487c7915bcdd");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Course","Semister");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Course`");
      _db.execSQL("DELETE FROM `Semister`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CourseDao courseDao() {
    if (_courseDao != null) {
      return _courseDao;
    } else {
      synchronized(this) {
        if(_courseDao == null) {
          _courseDao = new CourseDao_Impl(this);
        }
        return _courseDao;
      }
    }
  }

  @Override
  public SemisterDao semisterDao() {
    if (_semisterDao != null) {
      return _semisterDao;
    } else {
      synchronized(this) {
        if(_semisterDao == null) {
          _semisterDao = new SemisterDao_Impl(this);
        }
        return _semisterDao;
      }
    }
  }
}
