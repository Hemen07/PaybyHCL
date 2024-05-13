// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "UNUSED_PARAMETER", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN", "IMPLICIT_NOTHING_TYPE_ARGUMENT_IN_RETURN_POSITION")

package com.hcl.hclpayby.`data`.microservices.entities.responses

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.`internal`.Util
import java.lang.NullPointerException
import java.lang.reflect.Constructor
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.emptySet
import kotlin.jvm.Volatile
import kotlin.text.buildString

public class OtpResponseJsonAdapter(
  moshi: Moshi,
) : JsonAdapter<OtpResponse>() {
  private val options: JsonReader.Options = JsonReader.Options.of("status")

  private val nullableStringAdapter: JsonAdapter<String?> = moshi.adapter(String::class.java,
      emptySet(), "status")

  @Volatile
  private var constructorRef: Constructor<OtpResponse>? = null

  override fun toString(): String = buildString(33) {
      append("GeneratedJsonAdapter(").append("OtpResponse").append(')') }

  override fun fromJson(reader: JsonReader): OtpResponse {
    var status: String? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          status = nullableStringAdapter.fromJson(reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfffffffe.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  OtpResponse(
          status = status
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<OtpResponse> = this.constructorRef ?:
          OtpResponse::class.java.getDeclaredConstructor(String::class.java,
          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {
          this.constructorRef = it }
      return localConstructor.newInstance(
          status,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  override fun toJson(writer: JsonWriter, value_: OtpResponse?) {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("status")
    nullableStringAdapter.toJson(writer, value_.status)
    writer.endObject()
  }
}