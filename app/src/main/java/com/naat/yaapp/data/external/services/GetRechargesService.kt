package com.naat.yaapp.data.external.services

import com.google.gson.Gson
import com.naat.yaapp.data.external.configuration.ServiceListener
import com.naat.yaapp.data.models.Recharge

class GetRechargesService(private val listener: ServiceListener<Array<Recharge>, Boolean>) {

    fun callService() {
        val json =
            "[{ 'companyName': 'Claro', 'idRecharge': 1, 'price': 10.0, 'serviceType': 1, 'value': '\$10.00'}, { 'companyName': 'Claro', 'idRecharge': 2, 'price': 30.0, 'serviceType': 1, 'value': '\$30.00'}, { 'companyName': 'Claro', 'idRecharge': 3, 'price': 50.0, 'serviceType': 1, 'value': '\$50.00'}, { 'companyName': 'Claro', 'idRecharge': 4, 'price': 100.0, 'serviceType': 1, 'value': '\$100.00'}, { 'companyName': 'Claro', 'idRecharge': 5, 'price': 200.0, 'serviceType': 1, 'value': '\$200.00'}, { 'companyName': 'Claro', 'idRecharge': 6, 'price': 500.0, 'serviceType': 1, 'value': '\$500.00'}, { 'companyName': 'Claro', 'idRecharge': 7, 'price': 1000.0, 'serviceType': 1, 'value': '\$1000.00'}, { 'companyName': 'Claro', 'idRecharge': 8, 'price': 20.0, 'serviceType': 2, 'value': '100Mb'}, { 'companyName': 'Claro', 'idRecharge': 9, 'price': 30.0, 'serviceType': 2, 'value': '200Mb'}, { 'companyName': 'Claro', 'idRecharge': 10, 'price': 60.0, 'serviceType': 2, 'value': '500Mb'}, { 'companyName': 'Claro', 'idRecharge': 11, 'price': 100.0, 'serviceType': 2, 'value': '1Gb'}, { 'companyName': 'Claro', 'idRecharge': 12, 'price': 150.0, 'serviceType': 2, 'value': '2Gb'}, { 'companyName': 'Claro', 'idRecharge': 13, 'price': 250.0, 'serviceType': 2, 'value': '5Gb'}, { 'companyName': 'Tuenti', 'idRecharge': 14, 'price': 30.0, 'serviceType': 1, 'value': '\$30.00'}, { 'companyName': 'Tuenti', 'idRecharge': 15, 'price': 50.0, 'serviceType': 1, 'value': '\$50.00'}, { 'companyName': 'Tuenti', 'idRecharge': 16, 'price': 100.0, 'serviceType': 1, 'value': '\$100.00'}, { 'companyName': 'Tuenti', 'idRecharge': 17, 'price': 200.0, 'serviceType': 1, 'value': '\$200.00'}, { 'companyName': 'Tuenti', 'idRecharge': 18, 'price': 500.0, 'serviceType': 1, 'value': '\$500.00'}, { 'companyName': 'Tuenti', 'idRecharge': 19, 'price': 10.0, 'serviceType': 2, 'value': '100Mb'}, { 'companyName': 'Tuenti', 'idRecharge': 20, 'price': 30.0, 'serviceType': 2, 'value': '500Mb'}, { 'companyName': 'Tuenti', 'idRecharge': 21, 'price': 50.0, 'serviceType': 2, 'value': '1Gb'}, { 'companyName': 'Tuenti', 'idRecharge': 22, 'price': 200.0, 'serviceType': 2, 'value': '5Gb'}, { 'companyName': 'Entel', 'idRecharge': 23, 'price': 100.0, 'serviceType': 1, 'value': '\$100.00'}, { 'companyName': 'Entel', 'idRecharge': 24, 'price': 200.0, 'serviceType': 1, 'value': '\$200.00'}, { 'companyName': 'Entel', 'idRecharge': 25, 'price': 500.0, 'serviceType': 1, 'value': '\$500.00'}, { 'companyName': 'Entel', 'idRecharge': 26, 'price': 1000.0, 'serviceType': 1, 'value': '\$1000.00'}, { 'companyName': 'Entel', 'idRecharge': 27, 'price': 40.0, 'serviceType': 2, 'value': '100Mb'}, { 'companyName': 'Entel', 'idRecharge': 28, 'price': 60.0, 'serviceType': 2, 'value': '200Mb'}, { 'companyName': 'Entel', 'idRecharge': 29, 'price': 150.0, 'serviceType': 2, 'value': '1Gb'}, { 'companyName': 'Entel', 'idRecharge': 30, 'price': 250.0, 'serviceType': 2, 'value': '2Gb'}]"
        val gson = Gson()
        val array = gson.fromJson(json, Array<Recharge>::class.java)
        listener.onServiceSucceed(array)
    }
}