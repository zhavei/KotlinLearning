package com.example.kotlinlearning

import android.content.Context
import com.example.kotlinlearning.adapter.ItemAdapter
import com.example.kotlinlearning.model.Affirmation
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationsAdapterTests {
    private val context = mock(Context::class.java)

    @Test
    fun adapter_size(){
        val data = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2)
        )

        val adapter = ItemAdapter(context, data)
        assertEquals("Item adapter is not correct size", data.size, adapter.itemCount)
    }

}