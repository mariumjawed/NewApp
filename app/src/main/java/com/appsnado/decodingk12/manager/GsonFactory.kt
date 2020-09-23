package com.appsnado.decodingk12.manager

import com.google.gson.*
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object GsonFactory
  /* { val DATE_FROMAT = "dd-MM-yyyy"
    val DATE_FROMAT_2 = "dd/MM/yyyy"
    val TIME_FROMAT = "HH:mm:ss"
    val DATE_TIME_FROMAT = "yyyy-MM-dd HH:mm:ss"

    private var configuredGson: Gson? = null
    private var simpleGson: Gson? = null

    fun getConfiguredGson(): Gson? {
        if (configuredGson == null) {
            val builder = GsonBuilder()
            // Date
            builder.registerTypeAdapter(
                ServiceDate::class.java,
                ServiceDateSerializer(DATE_FROMAT)
            )

            // Date
            builder.registerTypeAdapter(
                ServiceDate::class.java,
                ServiceDateSerializer(DATE_TIME_FROMAT)
            )
            // Time
            builder.registerTypeAdapter(
                ServiceTime::class.java,
                ServiceTimeSerializer(TIME_FROMAT)
            )
            // Date Time
            builder.registerTypeAdapter(
                ServiceDateTime::class.java,
                ServiceDateTimeSerializer(DATE_TIME_FROMAT)
            )
            // java.util.Date
            builder.registerTypeAdapter(
                Date::class.java, DateSerializer(
                    DATE_TIME_FROMAT
                )
            )
            configuredGson = builder.create()
        }
        return configuredGson
    }

    fun getSimpleGson(): Gson? {
        if (simpleGson == null) {
            val builder = GsonBuilder()
            // Date
            builder.registerTypeAdapter(
                ServiceDate::class.java,
                ServiceDateSerializer(DATE_FROMAT)
            )
            // Time
            builder.registerTypeAdapter(
                ServiceTime::class.java,
                ServiceTimeSerializer(TIME_FROMAT)
            )
            // Date Time
            builder.registerTypeAdapter(
                ServiceDateTime::class.java,
                ServiceDateTimeSerializer(DATE_TIME_FROMAT)
            )
            // java.util.Date
            builder.registerTypeAdapter(
                Date::class.java, DateSerializer(
                    DATE_TIME_FROMAT
                )
            )
            simpleGson = builder.create()
        }
        return simpleGson
    }

    class ServiceDateSerializer(format: String?) :
        JsonSerializer<ServiceDate?>, JsonDeserializer<ServiceDate?> {
        var sf: SimpleDateFormat
        override fun serialize(
            src: ServiceDate, typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            return JsonPrimitive(sf.format(src.getDate()))
        }

        @Throws(JsonParseException::class)
        override fun deserialize(
            json: JsonElement, arg1: Type?,
            arg2: JsonDeserializationContext?
        ): ServiceDate? {
            val date = ServiceDate()
            try {
                date.setDate(
                    sf
                        .parse(json.asJsonPrimitive.asString)
                )
            } catch (e: ParseException) {
                // TODO : Add proper logs.
                return null
            }
            return date
        }

        init {
            sf = SimpleDateFormat(format)
        }
    }

    class ServiceTimeSerializer(format: String?) :
        JsonSerializer<ServiceTime?>, JsonDeserializer<ServiceTime?> {
        var sf: SimpleDateFormat
        override fun serialize(
            src: ServiceTime, typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            return JsonPrimitive(sf.format(src.getDate()))
        }

        @Throws(JsonParseException::class)
        override fun deserialize(
            json: JsonElement, arg1: Type?,
            arg2: JsonDeserializationContext?
        ): ServiceTime? {
            val time = ServiceTime()
            try {
                time.setDate(
                    sf
                        .parse(json.asJsonPrimitive.asString)
                )
            } catch (e: ParseException) {
                // TODO : Add proper logs.
                return null
            }
            return time
        }

        init {
            sf = SimpleDateFormat(format)
        }
    }

    class ServiceDateTimeSerializer(format: String?) :
        JsonSerializer<ServiceDateTime?>, JsonDeserializer<ServiceDateTime?> {
        var sf: SimpleDateFormat

        @Throws(JsonParseException::class)
        override fun deserialize(
            json: JsonElement, arg1: Type?,
            arg2: JsonDeserializationContext?
        ): ServiceDateTime? {
            val time = ServiceDateTime()
            try {
                time.setDate(
                    sf
                        .parse(json.asJsonPrimitive.asString)
                )
            } catch (e: ParseException) {
                // TODO : Add proper logs.
                return null
            }
            return time
        }

        override fun serialize(
            src: ServiceDateTime, arg1: Type?,
            arg2: JsonSerializationContext?
        ): JsonElement {
            return JsonPrimitive(sf.format(src.getDate()))
        }

        init {
            sf = SimpleDateFormat(format)
        }
    }

    class DateSerializer(format: String?) : JsonSerializer<Date>,
        JsonDeserializer<Date?> {
        var sf: SimpleDateFormat

        @Throws(JsonParseException::class)
        override fun deserialize(
            json: JsonElement, arg1: Type,
            arg2: JsonDeserializationContext?
        ): Date? {
            var time: Date? = null
            time = try {
                sf.parse(json.asJsonPrimitive.asString)
            } catch (e: ParseException) {
                // TODO : Add proper logs.
                return null
            }
            return time
        }

        override fun serialize(
            src: Date, arg1: Type,
            arg2: JsonSerializationContext?
        ): JsonElement {
            return JsonPrimitive(sf.format(src))
        }

        init {
            sf = SimpleDateFormat(format)
        }
    }

}*/
