package com.example.recyclerviewjusto.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.recyclerviewjusto.dao.PokemonDAO;
import com.example.recyclerviewjusto.dao.PokemonDAO_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PokemonDatabase_Impl extends PokemonDatabase {
  private volatile PokemonDAO _pokemonDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `pokemon` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT, `tipo` TEXT, `debilidad` TEXT, `peso` REAL NOT NULL, `altura` REAL NOT NULL, `imagen` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9b11f54d6ca8fa1d2c36932ca7e0d3d1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `pokemon`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
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
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPokemon = new HashMap<String, TableInfo.Column>(7);
        _columnsPokemon.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemon.put("nombre", new TableInfo.Column("nombre", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemon.put("tipo", new TableInfo.Column("tipo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemon.put("debilidad", new TableInfo.Column("debilidad", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemon.put("peso", new TableInfo.Column("peso", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemon.put("altura", new TableInfo.Column("altura", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemon.put("imagen", new TableInfo.Column("imagen", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPokemon = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPokemon = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPokemon = new TableInfo("pokemon", _columnsPokemon, _foreignKeysPokemon, _indicesPokemon);
        final TableInfo _existingPokemon = TableInfo.read(_db, "pokemon");
        if (! _infoPokemon.equals(_existingPokemon)) {
          return new RoomOpenHelper.ValidationResult(false, "pokemon(com.example.recyclerviewjusto.entity.Pokemon).\n"
                  + " Expected:\n" + _infoPokemon + "\n"
                  + " Found:\n" + _existingPokemon);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9b11f54d6ca8fa1d2c36932ca7e0d3d1", "03e77248b97a107186cba23802f25f1a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "pokemon");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `pokemon`");
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
  public PokemonDAO getPokemonDAO() {
    if (_pokemonDAO != null) {
      return _pokemonDAO;
    } else {
      synchronized(this) {
        if(_pokemonDAO == null) {
          _pokemonDAO = new PokemonDAO_Impl(this);
        }
        return _pokemonDAO;
      }
    }
  }
}
