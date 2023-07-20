package com.rsmartin.oompaloompa.di

import com.rsmartin.data.RestClient
import com.rsmartin.data.error.ErrorHandler
import com.rsmartin.data.repository.OompaLoompaRepository
import com.rsmartin.domain.datasource.OompaLoompaDataSource
import com.rsmartin.domain.usecase.GetOompaLoompa
import com.rsmartin.domain.usecase.GetOompaLoompas
import com.rsmartin.oompaloompa.presentation.oompaloompadetail.OompaLoompaDetailViewModel
import com.rsmartin.oompaloompa.presentation.oompaloompalist.OompaLoompaListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { OompaLoompaListViewModel(get()) }
    viewModel { OompaLoompaDetailViewModel(get()) }
//    single { HeroesListMapper() }
//    single { HeroDetailMapper() }
}

val domainModule = module {
    single { GetOompaLoompas(get()) }
    single { GetOompaLoompa(get()) }
}

val dataModule = module {
    single<OompaLoompaDataSource> { OompaLoompaRepository(get(), get()) }
    single { RestClient.getOompaLoompaApi() }
    single { ErrorHandler() }
}