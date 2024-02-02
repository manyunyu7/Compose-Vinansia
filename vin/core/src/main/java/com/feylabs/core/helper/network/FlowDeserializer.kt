package com.feylabs.core.helper.network

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.lang.reflect.Type

// Define a custom deserializer for the Flow class using the JsonDeserializer interface from the Gson library.
class FlowDeserializer : JsonDeserializer<Flow<*>> {

    // The deserialize method is called by Gson when it encounters a Flow object during deserialization.
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Flow<*> {

        // First, deserialize the JSON string into a list of objects using Gson's fromJson method.
        // Create a TypeToken for a list of unknown objects, which allows Gson to deserialize the JSON string into a list of any type of object.
        val type = object : TypeToken<List<*>>() {}.type
        val list = Gson().fromJson<List<*>>(json, type)

        // Convert the list into a Flow object using the flowOf function from the Kotlin coroutines library.
        // The flowOf function creates a Flow object from a vararg of items.
        return flowOf(*list.toTypedArray())
    }
}