package com.cendekia.unittesting

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    //initialize the method before performing the test
    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    //@test method to test
    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        //validate the expected output and the actual output.
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getCircumference()
        assertEquals(dummyCircumference, volume, 0.0001)
    }

    @Test
    fun tesSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, volume, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        //check invoked method with the given argument (framework mockito)
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockCircumference() {
        `when`(mainViewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = mainViewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        //'when' is event where you want to manipulate the behavior of the mock object.
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }
}