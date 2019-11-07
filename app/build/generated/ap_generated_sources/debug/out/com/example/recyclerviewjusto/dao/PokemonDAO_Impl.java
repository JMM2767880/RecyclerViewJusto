package com.example.recyclerviewjusto.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.recyclerviewjusto.entity.Pokemon;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PokemonDAO_Impl implements PokemonDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pokemon> __insertionAdapterOfPokemon;

  private final EntityDeletionOrUpdateAdapter<Pokemon> __deletionAdapterOfPokemon;

  private final EntityDeletionOrUpdateAdapter<Pokemon> __updateAdapterOfPokemon;

  public PokemonDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPokemon = new EntityInsertionAdapter<Pokemon>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `pokemon` (`id`,`nombre`,`tipo`,`debilidad`,`peso`,`altura`,`imagen`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pokemon value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getTipo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTipo());
        }
        if (value.getDebilidad() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDebilidad());
        }
        stmt.bindDouble(5, value.getPeso());
        stmt.bindDouble(6, value.getAltura());
        stmt.bindLong(7, value.getImagen());
      }
    };
    this.__deletionAdapterOfPokemon = new EntityDeletionOrUpdateAdapter<Pokemon>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `pokemon` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pokemon value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPokemon = new EntityDeletionOrUpdateAdapter<Pokemon>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `pokemon` SET `id` = ?,`nombre` = ?,`tipo` = ?,`debilidad` = ?,`peso` = ?,`altura` = ?,`imagen` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pokemon value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getTipo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTipo());
        }
        if (value.getDebilidad() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDebilidad());
        }
        stmt.bindDouble(5, value.getPeso());
        stmt.bindDouble(6, value.getAltura());
        stmt.bindLong(7, value.getImagen());
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public long insert(final Pokemon pokemon) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfPokemon.insertAndReturnId(pokemon);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int delete(final Pokemon pokemon) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfPokemon.handle(pokemon);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int edit(final Pokemon pokemon) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfPokemon.handle(pokemon);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Pokemon get(final int id) {
    final String _sql = "select * from pokemon where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfDebilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "debilidad");
      final int _cursorIndexOfPeso = CursorUtil.getColumnIndexOrThrow(_cursor, "peso");
      final int _cursorIndexOfAltura = CursorUtil.getColumnIndexOrThrow(_cursor, "altura");
      final int _cursorIndexOfImagen = CursorUtil.getColumnIndexOrThrow(_cursor, "imagen");
      final Pokemon _result;
      if(_cursor.moveToFirst()) {
        _result = new Pokemon();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        _result.setNombre(_tmpNombre);
        final String _tmpTipo;
        _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        _result.setTipo(_tmpTipo);
        final String _tmpDebilidad;
        _tmpDebilidad = _cursor.getString(_cursorIndexOfDebilidad);
        _result.setDebilidad(_tmpDebilidad);
        final double _tmpPeso;
        _tmpPeso = _cursor.getDouble(_cursorIndexOfPeso);
        _result.setPeso(_tmpPeso);
        final double _tmpAltura;
        _tmpAltura = _cursor.getDouble(_cursorIndexOfAltura);
        _result.setAltura(_tmpAltura);
        final int _tmpImagen;
        _tmpImagen = _cursor.getInt(_cursorIndexOfImagen);
        _result.setImagen(_tmpImagen);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Pokemon> getAll() {
    final String _sql = "select * from pokemon order by nombre, tipo, id desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfDebilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "debilidad");
      final int _cursorIndexOfPeso = CursorUtil.getColumnIndexOrThrow(_cursor, "peso");
      final int _cursorIndexOfAltura = CursorUtil.getColumnIndexOrThrow(_cursor, "altura");
      final int _cursorIndexOfImagen = CursorUtil.getColumnIndexOrThrow(_cursor, "imagen");
      final List<Pokemon> _result = new ArrayList<Pokemon>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Pokemon _item;
        _item = new Pokemon();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        _item.setNombre(_tmpNombre);
        final String _tmpTipo;
        _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        _item.setTipo(_tmpTipo);
        final String _tmpDebilidad;
        _tmpDebilidad = _cursor.getString(_cursorIndexOfDebilidad);
        _item.setDebilidad(_tmpDebilidad);
        final double _tmpPeso;
        _tmpPeso = _cursor.getDouble(_cursorIndexOfPeso);
        _item.setPeso(_tmpPeso);
        final double _tmpAltura;
        _tmpAltura = _cursor.getDouble(_cursorIndexOfAltura);
        _item.setAltura(_tmpAltura);
        final int _tmpImagen;
        _tmpImagen = _cursor.getInt(_cursorIndexOfImagen);
        _item.setImagen(_tmpImagen);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Pokemon>> getAllLive() {
    final String _sql = "select * from pokemon order by nombre, tipo, id desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"pokemon"}, false, new Callable<List<Pokemon>>() {
      @Override
      public List<Pokemon> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfDebilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "debilidad");
          final int _cursorIndexOfPeso = CursorUtil.getColumnIndexOrThrow(_cursor, "peso");
          final int _cursorIndexOfAltura = CursorUtil.getColumnIndexOrThrow(_cursor, "altura");
          final int _cursorIndexOfImagen = CursorUtil.getColumnIndexOrThrow(_cursor, "imagen");
          final List<Pokemon> _result = new ArrayList<Pokemon>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Pokemon _item;
            _item = new Pokemon();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpNombre;
            _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            _item.setNombre(_tmpNombre);
            final String _tmpTipo;
            _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            _item.setTipo(_tmpTipo);
            final String _tmpDebilidad;
            _tmpDebilidad = _cursor.getString(_cursorIndexOfDebilidad);
            _item.setDebilidad(_tmpDebilidad);
            final double _tmpPeso;
            _tmpPeso = _cursor.getDouble(_cursorIndexOfPeso);
            _item.setPeso(_tmpPeso);
            final double _tmpAltura;
            _tmpAltura = _cursor.getDouble(_cursorIndexOfAltura);
            _item.setAltura(_tmpAltura);
            final int _tmpImagen;
            _tmpImagen = _cursor.getInt(_cursorIndexOfImagen);
            _item.setImagen(_tmpImagen);
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
    });
  }

  @Override
  public List<Pokemon> getPokemons() {
    final String _sql = "select * from pokemon order by nombre desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfDebilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "debilidad");
      final int _cursorIndexOfPeso = CursorUtil.getColumnIndexOrThrow(_cursor, "peso");
      final int _cursorIndexOfAltura = CursorUtil.getColumnIndexOrThrow(_cursor, "altura");
      final int _cursorIndexOfImagen = CursorUtil.getColumnIndexOrThrow(_cursor, "imagen");
      final List<Pokemon> _result = new ArrayList<Pokemon>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Pokemon _item;
        _item = new Pokemon();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        _item.setNombre(_tmpNombre);
        final String _tmpTipo;
        _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        _item.setTipo(_tmpTipo);
        final String _tmpDebilidad;
        _tmpDebilidad = _cursor.getString(_cursorIndexOfDebilidad);
        _item.setDebilidad(_tmpDebilidad);
        final double _tmpPeso;
        _tmpPeso = _cursor.getDouble(_cursorIndexOfPeso);
        _item.setPeso(_tmpPeso);
        final double _tmpAltura;
        _tmpAltura = _cursor.getDouble(_cursorIndexOfAltura);
        _item.setAltura(_tmpAltura);
        final int _tmpImagen;
        _tmpImagen = _cursor.getInt(_cursorIndexOfImagen);
        _item.setImagen(_tmpImagen);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
