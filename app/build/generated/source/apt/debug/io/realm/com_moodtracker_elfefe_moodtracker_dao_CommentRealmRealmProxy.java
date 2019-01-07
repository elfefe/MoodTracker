package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy extends com.moodtracker.elfefe.moodtracker.dao.CommentRealm
    implements RealmObjectProxy, com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface {

    static final class CommentRealmColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long commentIndex;
        long feelingIndex;

        CommentRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("CommentRealm");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.commentIndex = addColumnDetails("comment", "comment", objectSchemaInfo);
            this.feelingIndex = addColumnDetails("feeling", "feeling", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        CommentRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CommentRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CommentRealmColumnInfo src = (CommentRealmColumnInfo) rawSrc;
            final CommentRealmColumnInfo dst = (CommentRealmColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.commentIndex = src.commentIndex;
            dst.feelingIndex = src.feelingIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CommentRealmColumnInfo columnInfo;
    private ProxyState<com.moodtracker.elfefe.moodtracker.dao.CommentRealm> proxyState;

    com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CommentRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.moodtracker.elfefe.moodtracker.dao.CommentRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$comment() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.commentIndex);
    }

    @Override
    public void realmSet$comment(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.commentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.commentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.commentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.commentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$feeling() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.feelingIndex);
    }

    @Override
    public void realmSet$feeling(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.feelingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.feelingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.feelingIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.feelingIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("CommentRealm", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("comment", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("feeling", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CommentRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CommentRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "CommentRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "CommentRealm";
    }

    @SuppressWarnings("cast")
    public static com.moodtracker.elfefe.moodtracker.dao.CommentRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.moodtracker.elfefe.moodtracker.dao.CommentRealm obj = null;
        if (update) {
            Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
            CommentRealmColumnInfo columnInfo = (CommentRealmColumnInfo) realm.getSchema().getColumnInfo(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy) realm.createObjectInternal(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy) realm.createObjectInternal(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface objProxy = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) obj;
        if (json.has("comment")) {
            if (json.isNull("comment")) {
                objProxy.realmSet$comment(null);
            } else {
                objProxy.realmSet$comment((String) json.getString("comment"));
            }
        }
        if (json.has("feeling")) {
            if (json.isNull("feeling")) {
                objProxy.realmSet$feeling(null);
            } else {
                objProxy.realmSet$feeling((String) json.getString("feeling"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.moodtracker.elfefe.moodtracker.dao.CommentRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.moodtracker.elfefe.moodtracker.dao.CommentRealm obj = new com.moodtracker.elfefe.moodtracker.dao.CommentRealm();
        final com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface objProxy = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("comment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$comment((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$comment(null);
                }
            } else if (name.equals("feeling")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$feeling((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$feeling(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating uexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class), false, Collections.<String>emptyList());
        io.realm.com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy obj = new io.realm.com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.moodtracker.elfefe.moodtracker.dao.CommentRealm copyOrUpdate(Realm realm, CommentRealmColumnInfo columnInfo, com.moodtracker.elfefe.moodtracker.dao.CommentRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.moodtracker.elfefe.moodtracker.dao.CommentRealm) cachedRealmObject;
        }

        com.moodtracker.elfefe.moodtracker.dao.CommentRealm realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.moodtracker.elfefe.moodtracker.dao.CommentRealm copy(Realm realm, CommentRealmColumnInfo columnInfo, com.moodtracker.elfefe.moodtracker.dao.CommentRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.moodtracker.elfefe.moodtracker.dao.CommentRealm) cachedRealmObject;
        }

        com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface realmObjectSource = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.commentIndex, realmObjectSource.realmGet$comment());
        builder.addString(columnInfo.feelingIndex, realmObjectSource.realmGet$feeling());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.moodtracker.elfefe.moodtracker.dao.CommentRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long tableNativePtr = table.getNativePtr();
        CommentRealmColumnInfo columnInfo = (CommentRealmColumnInfo) realm.getSchema().getColumnInfo(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$comment = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$comment();
        if (realmGet$comment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
        }
        String realmGet$feeling = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$feeling();
        if (realmGet$feeling != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.feelingIndex, rowIndex, realmGet$feeling, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long tableNativePtr = table.getNativePtr();
        CommentRealmColumnInfo columnInfo = (CommentRealmColumnInfo) realm.getSchema().getColumnInfo(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.moodtracker.elfefe.moodtracker.dao.CommentRealm object = null;
        while (objects.hasNext()) {
            object = (com.moodtracker.elfefe.moodtracker.dao.CommentRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$comment = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$comment();
            if (realmGet$comment != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
            }
            String realmGet$feeling = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$feeling();
            if (realmGet$feeling != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.feelingIndex, rowIndex, realmGet$feeling, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.moodtracker.elfefe.moodtracker.dao.CommentRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long tableNativePtr = table.getNativePtr();
        CommentRealmColumnInfo columnInfo = (CommentRealmColumnInfo) realm.getSchema().getColumnInfo(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$comment = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$comment();
        if (realmGet$comment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.commentIndex, rowIndex, false);
        }
        String realmGet$feeling = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$feeling();
        if (realmGet$feeling != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.feelingIndex, rowIndex, realmGet$feeling, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.feelingIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long tableNativePtr = table.getNativePtr();
        CommentRealmColumnInfo columnInfo = (CommentRealmColumnInfo) realm.getSchema().getColumnInfo(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.moodtracker.elfefe.moodtracker.dao.CommentRealm object = null;
        while (objects.hasNext()) {
            object = (com.moodtracker.elfefe.moodtracker.dao.CommentRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$comment = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$comment();
            if (realmGet$comment != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.commentIndex, rowIndex, realmGet$comment, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.commentIndex, rowIndex, false);
            }
            String realmGet$feeling = ((com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) object).realmGet$feeling();
            if (realmGet$feeling != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.feelingIndex, rowIndex, realmGet$feeling, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.feelingIndex, rowIndex, false);
            }
        }
    }

    public static com.moodtracker.elfefe.moodtracker.dao.CommentRealm createDetachedCopy(com.moodtracker.elfefe.moodtracker.dao.CommentRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.moodtracker.elfefe.moodtracker.dao.CommentRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.moodtracker.elfefe.moodtracker.dao.CommentRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.moodtracker.elfefe.moodtracker.dao.CommentRealm) cachedObject.object;
            }
            unmanagedObject = (com.moodtracker.elfefe.moodtracker.dao.CommentRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface unmanagedCopy = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) unmanagedObject;
        com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface realmSource = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$comment(realmSource.realmGet$comment());
        unmanagedCopy.realmSet$feeling(realmSource.realmGet$feeling());

        return unmanagedObject;
    }

    static com.moodtracker.elfefe.moodtracker.dao.CommentRealm update(Realm realm, CommentRealmColumnInfo columnInfo, com.moodtracker.elfefe.moodtracker.dao.CommentRealm realmObject, com.moodtracker.elfefe.moodtracker.dao.CommentRealm newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface realmObjectTarget = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) realmObject;
        com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface realmObjectSource = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxyInterface) newObject;
        Table table = realm.getTable(com.moodtracker.elfefe.moodtracker.dao.CommentRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.commentIndex, realmObjectSource.realmGet$comment());
        builder.addString(columnInfo.feelingIndex, realmObjectSource.realmGet$feeling());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CommentRealm = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comment:");
        stringBuilder.append(realmGet$comment() != null ? realmGet$comment() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{feeling:");
        stringBuilder.append(realmGet$feeling() != null ? realmGet$feeling() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy aCommentRealm = (com_moodtracker_elfefe_moodtracker_dao_CommentRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCommentRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCommentRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCommentRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
