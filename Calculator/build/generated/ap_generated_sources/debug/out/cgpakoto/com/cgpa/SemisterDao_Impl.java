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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class SemisterDao_Impl implements SemisterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSemister;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfSemister;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSemister;

  public SemisterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSemister = new EntityInsertionAdapter<Semister>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Semister`(`id`,`cgpa`,`totalcredit`,`semister_name`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Semister value) {
        stmt.bindLong(1, value.getId());
        stmt.bindDouble(2, value.getCgpa());
        stmt.bindDouble(3, value.getTotalcredit());
        if (value.getSemister_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSemister_name());
        }
      }
    };
    this.__updateAdapterOfSemister = new EntityDeletionOrUpdateAdapter<Semister>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Semister` SET `id` = ?,`cgpa` = ?,`totalcredit` = ?,`semister_name` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Semister value) {
        stmt.bindLong(1, value.getId());
        stmt.bindDouble(2, value.getCgpa());
        stmt.bindDouble(3, value.getTotalcredit());
        if (value.getSemister_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSemister_name());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteSemister = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete From semister where semister_name like?";
        return _query;
      }
    };
  }

  @Override
  public long InsertSemister(Semister semister) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSemister.insertAndReturnId(semister);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateSemister(Semister semister) {
    __db.beginTransaction();
    try {
      __updateAdapterOfSemister.handle(semister);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteSemister(String seminame) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSemister.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (seminame == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, seminame);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSemister.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Semister>> GetAllSemisters() {
    final String _sql = "Select * from Semister ORDER BY id ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Semister>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Semister> compute() {
        if (_observer == null) {
          _observer = new Observer("Semister") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfCgpa = _cursor.getColumnIndexOrThrow("cgpa");
          final int _cursorIndexOfTotalcredit = _cursor.getColumnIndexOrThrow("totalcredit");
          final int _cursorIndexOfSemisterName = _cursor.getColumnIndexOrThrow("semister_name");
          final List<Semister> _result = new ArrayList<Semister>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Semister _item;
            final double _tmpCgpa;
            _tmpCgpa = _cursor.getDouble(_cursorIndexOfCgpa);
            final double _tmpTotalcredit;
            _tmpTotalcredit = _cursor.getDouble(_cursorIndexOfTotalcredit);
            final String _tmpSemister_name;
            _tmpSemister_name = _cursor.getString(_cursorIndexOfSemisterName);
            _item = new Semister(_tmpCgpa,_tmpSemister_name,_tmpTotalcredit);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
}
