package cgpakoto.com.cgpa;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class CourseDao_Impl implements CourseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCourse;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCourse;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCourse;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCourseOfSemister;

  public CourseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCourse = new EntityInsertionAdapter<Course>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Course`(`credit`,`gpa`,`id`,`semister_name`) VALUES (?,?,nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Course value) {
        if (value.getCredit() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindDouble(1, value.getCredit());
        }
        if (value.getGpa() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.getGpa());
        }
        stmt.bindLong(3, value.getId());
        if (value.getSemister_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSemister_name());
        }
      }
    };
    this.__deletionAdapterOfCourse = new EntityDeletionOrUpdateAdapter<Course>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Course` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Course value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfCourse = new EntityDeletionOrUpdateAdapter<Course>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Course` SET `credit` = ?,`gpa` = ?,`id` = ?,`semister_name` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Course value) {
        if (value.getCredit() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindDouble(1, value.getCredit());
        }
        if (value.getGpa() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.getGpa());
        }
        stmt.bindLong(3, value.getId());
        if (value.getSemister_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSemister_name());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteCourseOfSemister = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete From Course where semister_name like ?";
        return _query;
      }
    };
  }

  @Override
  public void InsertCourse(Course course) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCourse.insert(course);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteCourse(Course course) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCourse.handle(course);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateCourse(Course course) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCourse.handle(course);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteCourseOfSemister(String name) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCourseOfSemister.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (name == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, name);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCourseOfSemister.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Course>> GetAllCourses() {
    final String _sql = "Select * from Course ORDER BY id ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Course>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Course> compute() {
        if (_observer == null) {
          _observer = new Observer("Course") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfCredit = _cursor.getColumnIndexOrThrow("credit");
          final int _cursorIndexOfGpa = _cursor.getColumnIndexOrThrow("gpa");
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfSemisterName = _cursor.getColumnIndexOrThrow("semister_name");
          final List<Course> _result = new ArrayList<Course>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Course _item;
            final Double _tmpCredit;
            if (_cursor.isNull(_cursorIndexOfCredit)) {
              _tmpCredit = null;
            } else {
              _tmpCredit = _cursor.getDouble(_cursorIndexOfCredit);
            }
            final Double _tmpGpa;
            if (_cursor.isNull(_cursorIndexOfGpa)) {
              _tmpGpa = null;
            } else {
              _tmpGpa = _cursor.getDouble(_cursorIndexOfGpa);
            }
            _item = new Course(_tmpCredit,_tmpGpa);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpSemister_name;
            _tmpSemister_name = _cursor.getString(_cursorIndexOfSemisterName);
            _item.setSemister_name(_tmpSemister_name);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public List<Course> GetCourseById(String name) {
    final String _sql = "select * from Course where semister_name like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCredit = _cursor.getColumnIndexOrThrow("credit");
      final int _cursorIndexOfGpa = _cursor.getColumnIndexOrThrow("gpa");
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfSemisterName = _cursor.getColumnIndexOrThrow("semister_name");
      final List<Course> _result = new ArrayList<Course>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Course _item;
        final Double _tmpCredit;
        if (_cursor.isNull(_cursorIndexOfCredit)) {
          _tmpCredit = null;
        } else {
          _tmpCredit = _cursor.getDouble(_cursorIndexOfCredit);
        }
        final Double _tmpGpa;
        if (_cursor.isNull(_cursorIndexOfGpa)) {
          _tmpGpa = null;
        } else {
          _tmpGpa = _cursor.getDouble(_cursorIndexOfGpa);
        }
        _item = new Course(_tmpCredit,_tmpGpa);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpSemister_name;
        _tmpSemister_name = _cursor.getString(_cursorIndexOfSemisterName);
        _item.setSemister_name(_tmpSemister_name);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
