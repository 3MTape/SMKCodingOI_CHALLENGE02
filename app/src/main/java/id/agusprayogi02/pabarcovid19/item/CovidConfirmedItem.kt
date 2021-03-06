package id.agusprayogi02.pabarcovid19.item

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CovidConfirmedItem(
    @SerializedName("active")
    val active: Int,
    @SerializedName("admin2")
    val admin2: String,
    @SerializedName("combinedKey")
    val combinedKey: String,
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("countryRegion")
    val countryRegion: String,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("fips")
    val fips: String,
    @SerializedName("incidentRate")
    val incidentRate: Double,
    @SerializedName("iso2")
    val iso2: String,
    @SerializedName("iso3")
    val iso3: String,
    @SerializedName("lastUpdate")
    val lastUpdate: Long,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("long")
    val long: Double,
    @SerializedName("peopleHospitalized")
    val peopleHospitalized: Any,
    @SerializedName("peopleTested")
    val peopleTested: Any,
    @SerializedName("provinceState")
    val provinceState: String,
    @SerializedName("recovered")
    val recovered: Int,
    @SerializedName("uid")
    val uid: Int
) : Serializable