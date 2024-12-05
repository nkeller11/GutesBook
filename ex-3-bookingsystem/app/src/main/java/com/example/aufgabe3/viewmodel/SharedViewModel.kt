package com.example.aufgabe3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aufgabe3.model.BookingEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class SharedViewModel: ViewModel() {
    private val _bookingsEntries = MutableStateFlow<List<BookingEntry>>(emptyList())
    val bookingsEntries: StateFlow<List<BookingEntry>> = _bookingsEntries

    fun addBookingEntry(arrivalDate:LocalDate, departureDate:LocalDate,name:String){
        val currentList= _bookingsEntries.value?: emptyList()
        val updatedList=currentList+BookingEntry(arrivalDate = arrivalDate, departureDate = departureDate, name = name)
        _bookingsEntries.value=updatedList
    }

    fun deleteBookingEntry(bookingEntry: BookingEntry){
        val currentList = _bookingsEntries.value ?: emptyList()
        val updatedList = currentList.filter { it != bookingEntry }
        _bookingsEntries.value = updatedList
    }
}