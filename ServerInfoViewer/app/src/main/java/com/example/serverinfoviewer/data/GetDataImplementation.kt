package com.example.serverinfoviewer.data

import android.util.Log
import com.example.serverinfoviewer.domain.entities.Address
import com.example.serverinfoviewer.domain.entities.Company
import com.example.serverinfoviewer.domain.entities.GeoData
import com.example.serverinfoviewer.domain.entities.User
import com.example.serverinfoviewer.domain.interfaces.GetDataInterface
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import javax.inject.Inject

class GetDataImplementation @Inject constructor(): GetDataInterface {

    private fun unpackGeoData(json: JSONObject) = GeoData(
        lat = json.getDouble(LAT_KEY),
        lng = json.getDouble(LNG_KEY)
    )

    private fun unpackAddress(json: JSONObject) = Address(
        street = json.getString(STREET_KEY),
        city = json.getString(CITY_KEY),
        zipcode = json.getString(ZIPCODE_KEY),
        suite = json.getString(SUITE_KEY),
        geo = unpackGeoData(json.getJSONObject(GEO_KEY)),
    )

    private fun unpackCompany(json: JSONObject) = Company(
        name = json.getString(NAME_KEY),
        catchPhrase = json.getString(CATCH_PHRASE_KEY),
        bs = json.getString(BS_KEY)
    )

    private fun unpackUser(json: JSONObject) = User(
        id = json.getInt(ID_KEY),
        name = json.getString(NAME_KEY),
        userName = json.getString(USER_NAME_KEY),
        email = json.getString(EMAIL_KEY),
        phone = json.getString(PHONE_KEY),
        address = unpackAddress(json.getJSONObject(ADDRESS_KEY)),
        company = unpackCompany(json.getJSONObject(COMPANY_KEY))
    )

    override fun getUserList(): List<User> {
        val text = URL(LINK).readText()
        val data = JSONArray(text)
        val result = mutableListOf<User>()
        val n = data.length()
        for (i in 0 until n) {
            val item = data.getJSONObject(i)
            result.add(unpackUser(item))
        }
        Log.i("mumu", result.toString())
        return result
    }

    companion object {
        private const val LINK = "https://jsonplaceholder.typicode.com/users"

        private const val ID_KEY = "id"
        private const val NAME_KEY = "name"
        private const val USER_NAME_KEY = "username"
        private const val EMAIL_KEY = "email"
        private const val PHONE_KEY = "phone"
        private const val ADDRESS_KEY = "address"
        private const val COMPANY_KEY = "company"
        private const val LAT_KEY = "lat"
        private const val LNG_KEY = "lng"
        private const val STREET_KEY = "street"
        private const val SUITE_KEY = "suite"
        private const val CITY_KEY = "city"
        private const val ZIPCODE_KEY = "zipcode"
        private const val GEO_KEY = "geo"
        private const val CATCH_PHRASE_KEY = "catchPhrase"
        private const val BS_KEY = "bs"
    }
}