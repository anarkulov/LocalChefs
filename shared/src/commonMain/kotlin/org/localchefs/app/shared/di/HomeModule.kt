package org.localchefs.app.shared.di

import org.koin.dsl.module
import org.localchefs.app.shared.presentation.home.HomeViewModel

val homeModule = module {
    factory { HomeViewModel() }
} 