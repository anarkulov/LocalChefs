package org.localchefs.app.shared.di

import org.koin.dsl.module
import org.localchefs.app.shared.data.api.AvailableDishApi
import org.localchefs.app.shared.network.HttpClientProvider
import org.localchefs.app.shared.data.remote.SupabaseClient
import org.localchefs.app.shared.data.remote.auth.AuthManager
import org.localchefs.app.shared.data.remote.auth.AuthManagerImpl
import org.localchefs.app.shared.data.api.ChefProfileApi
import org.localchefs.app.shared.data.api.ChefServiceBookingApi
import org.localchefs.app.shared.data.api.DishApi
import org.localchefs.app.shared.data.api.OrderApi
import org.localchefs.app.shared.data.repository.AvailableDishRepositoryImpl
import org.localchefs.app.shared.domain.repository.ChefProfileRepository
import org.localchefs.app.shared.data.repository.ChefProfileRepositoryImpl
import org.localchefs.app.shared.data.repository.ChefServiceBookingRepositoryImpl
import org.localchefs.app.shared.data.repository.DishRepositoryImpl
import org.localchefs.app.shared.data.repository.OrderRepositoryImpl
import org.localchefs.app.shared.domain.repository.OrderRepository
import org.localchefs.app.shared.domain.usecase.GetChefsUseCase
import org.localchefs.app.shared.domain.usecase.GetOrdersUseCase
import org.localchefs.app.shared.presentation.viewmodel.ChefProfileViewModel
import org.localchefs.app.shared.presentation.viewmodel.OrderViewModel
import org.localchefs.app.shared.domain.repository.DishRepository
import org.localchefs.app.shared.domain.usecase.GetDishesUseCase
import org.localchefs.app.shared.presentation.viewmodel.DishViewModel
import org.localchefs.app.shared.domain.repository.ChefServiceBookingRepository
import org.localchefs.app.shared.domain.usecase.serviceBooking.GetChefServiceBookingsUseCase
import org.localchefs.app.shared.presentation.viewmodel.ChefServiceBookingViewModel
import org.localchefs.app.shared.domain.repository.AvailableDishRepository
import org.localchefs.app.shared.domain.usecase.GetAvailableDishesUseCase
import org.localchefs.app.shared.presentation.viewmodel.AvailableDishViewModel
import org.localchefs.app.shared.data.api.CertificationApi
import org.localchefs.app.shared.data.repository.CertificationRepositoryImpl
import org.localchefs.app.shared.domain.repository.CertificationRepository
import org.localchefs.app.shared.domain.usecase.GetCertificationsUseCase
import org.localchefs.app.shared.presentation.viewmodel.CertificationViewModel
import org.localchefs.app.shared.data.api.ProfileApi
import org.localchefs.app.shared.data.repository.ProfileRepositoryImpl
import org.localchefs.app.shared.domain.repository.ProfileRepository
import org.localchefs.app.shared.domain.usecase.GetProfilesUseCase
import org.localchefs.app.shared.presentation.viewmodel.ProfileViewModel
import org.localchefs.app.shared.data.api.ReviewApi
import org.localchefs.app.shared.data.repository.ReviewRepositoryImpl
import org.localchefs.app.shared.domain.repository.ReviewRepository
import org.localchefs.app.shared.domain.usecase.review.GetReviewsUseCase
import org.localchefs.app.shared.presentation.viewmodel.ReviewViewModel
import org.localchefs.app.shared.data.api.DishCategoryApi
import org.localchefs.app.shared.data.repository.DishCategoryRepositoryImpl
import org.localchefs.app.shared.domain.repository.DishCategoryRepository
import org.localchefs.app.shared.domain.usecase.GetDishCategoriesUseCase
import org.localchefs.app.shared.presentation.viewmodel.DishCategoryViewModel
import org.localchefs.app.shared.data.api.ServiceApi
import org.localchefs.app.shared.data.repository.ServiceRepositoryImpl
import org.localchefs.app.shared.domain.repository.ServiceRepository
import org.localchefs.app.shared.domain.usecase.service.GetServicesUseCase
import org.localchefs.app.shared.presentation.viewmodel.ServiceViewModel
import org.localchefs.app.shared.data.api.ServiceCategoryApi
import org.localchefs.app.shared.data.repository.ServiceCategoryRepositoryImpl
import org.localchefs.app.shared.domain.repository.ServiceCategoryRepository
import org.localchefs.app.shared.domain.usecase.serviceCategory.GetServiceCategoriesUseCase
import org.localchefs.app.shared.presentation.viewmodel.ServiceCategoryViewModel
import org.localchefs.app.shared.data.api.StateApi
import org.localchefs.app.shared.data.repository.StateRepositoryImpl
import org.localchefs.app.shared.domain.repository.StateRepository
import org.localchefs.app.shared.domain.usecase.state.GetStatesUseCase
import org.localchefs.app.shared.presentation.viewmodel.StateViewModel
import org.localchefs.app.shared.data.api.FoodAllergenApi
import org.localchefs.app.shared.data.repository.FoodAllergenRepositoryImpl
import org.localchefs.app.shared.domain.repository.FoodAllergenRepository
import org.localchefs.app.shared.domain.usecase.foodAllergen.GetFoodAllergensUseCase
import org.localchefs.app.shared.presentation.viewmodel.FoodAllergenViewModel
import org.localchefs.app.shared.data.api.DietaryTagApi
import org.localchefs.app.shared.data.repository.DietaryTagRepositoryImpl
import org.localchefs.app.shared.domain.repository.DietaryTagRepository
import org.localchefs.app.shared.domain.usecase.dietaryTag.GetDietaryTagsUseCase
import org.localchefs.app.shared.presentation.viewmodel.DietaryTagViewModel
import org.localchefs.app.shared.data.api.OptionGroupApi
import org.localchefs.app.shared.data.repository.OptionGroupRepositoryImpl
import org.localchefs.app.shared.domain.repository.OptionGroupRepository
import org.localchefs.app.shared.data.api.OptionChoiceApi
import org.localchefs.app.shared.data.api.ProteinApi
import org.localchefs.app.shared.data.repository.OptionChoiceRepositoryImpl
import org.localchefs.app.shared.data.repository.ProteinRepositoryImpl
import org.localchefs.app.shared.domain.repository.OptionChoiceRepository
import org.localchefs.app.shared.domain.repository.ProteinRepository
import org.localchefs.app.shared.domain.usecase.option.GetOptionChoiceByIdUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionChoicesByGroupIdUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionChoicesUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionGroupByIdUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionGroupsUseCase
import org.localchefs.app.shared.domain.usecase.protein.GetProteinByIdUseCase
import org.localchefs.app.shared.domain.usecase.protein.GetProteinsUseCase
import org.localchefs.app.shared.presentation.viewmodel.OptionChoiceViewModel
import org.localchefs.app.shared.presentation.viewmodel.ProteinViewModel
import org.localchefs.app.shared.data.api.CertificationTypeApi
import org.localchefs.app.shared.data.repository.CertificationTypeRepositoryImpl
import org.localchefs.app.shared.domain.repository.CertificationTypeRepository
import org.localchefs.app.shared.domain.usecase.certification.GetCertificationTypeBySlugUseCase
import org.localchefs.app.shared.domain.usecase.certification.GetCertificationTypesUseCase
import org.localchefs.app.shared.presentation.viewmodel.CertificationTypeViewModel
import org.localchefs.app.shared.data.api.DeliveryTimeWindowApi
import org.localchefs.app.shared.data.repository.DeliveryTimeWindowRepositoryImpl
import org.localchefs.app.shared.domain.repository.DeliveryTimeWindowRepository
import org.localchefs.app.shared.domain.usecase.GetDeliveryTimeWindowsUseCase
import org.localchefs.app.shared.domain.usecase.GetDeliveryTimeWindowsByChefIdUseCase
import org.localchefs.app.shared.presentation.viewmodel.DeliveryTimeWindowViewModel
import org.localchefs.app.shared.data.api.NotificationApi
import org.localchefs.app.shared.data.repository.NotificationRepositoryImpl
import org.localchefs.app.shared.domain.repository.NotificationRepository
import org.localchefs.app.shared.domain.usecase.GetNotificationsUseCase
import org.localchefs.app.shared.domain.usecase.GetNotificationsByUserIdUseCase
import org.localchefs.app.shared.presentation.viewmodel.NotificationViewModel

val networkModule = module {
    single { HttpClientProvider().create() }
    single { SupabaseClient.client }
}

val authModule = module {
    single<AuthManager> { AuthManagerImpl() }
}

val chefProfileModule = module {
    single { ChefProfileApi(get()) }
    single<ChefProfileRepository> { ChefProfileRepositoryImpl(get()) }
    single { GetChefsUseCase(get()) }
    single { ChefProfileViewModel(get()) }
}

val orderModule = module {
     single { OrderApi(get()) }
     single<OrderRepository> { OrderRepositoryImpl(get()) }
     single { GetOrdersUseCase(get()) }
     single { OrderViewModel(get()) }
}

val dishModule = module {
    single { DishApi(get()) }
    single<DishRepository> { DishRepositoryImpl(get()) }
    single { GetDishesUseCase(get()) }
    single { DishViewModel(get()) }
}

val chefServiceBookingModule = module {
    single { ChefServiceBookingApi(get()) }
    single<ChefServiceBookingRepository> { ChefServiceBookingRepositoryImpl(get()) }
    single { GetChefServiceBookingsUseCase(get()) }
    single { ChefServiceBookingViewModel(get()) }
}

val availableDishModule = module {
    single { AvailableDishApi(get()) }
    single<AvailableDishRepository> { AvailableDishRepositoryImpl(get()) }
    single { GetAvailableDishesUseCase(get()) }
    single { AvailableDishViewModel(get()) }
}

val certificationModule = module {
    single { CertificationApi(get()) }
    single<CertificationRepository> { CertificationRepositoryImpl(get()) }
    single { GetCertificationsUseCase(get()) }
    single { CertificationViewModel(get()) }
}

val profileModule = module {
    single { ProfileApi(get()) }
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
    single { GetProfilesUseCase(get()) }
    single { ProfileViewModel(get()) }
}

val reviewModule = module {
    single { ReviewApi(get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get()) }
    single { GetReviewsUseCase(get()) }
    single { ReviewViewModel(get()) }
}

val dishCategoryModule = module {
    single { DishCategoryApi(get()) }
    single<DishCategoryRepository> { DishCategoryRepositoryImpl(get()) }
    single { GetDishCategoriesUseCase(get()) }
    single { DishCategoryViewModel(get()) }
}

val serviceModule = module {
    single { ServiceApi(get()) }
    single<ServiceRepository> { ServiceRepositoryImpl(get()) }
    single { GetServicesUseCase(get()) }
    single { ServiceViewModel(get()) }
}

val serviceCategoryModule = module {
    single { ServiceCategoryApi(get()) }
    single<ServiceCategoryRepository> { ServiceCategoryRepositoryImpl(get()) }
    single { GetServiceCategoriesUseCase(get()) }
    single { ServiceCategoryViewModel(get()) }
}

val stateModule = module {
    single { StateApi(get()) }
    single<StateRepository> { StateRepositoryImpl(get()) }
    single { GetStatesUseCase(get()) }
    single { StateViewModel(get()) }
}

val foodAllergenModule = module {
    single { FoodAllergenApi(get()) }
    single<FoodAllergenRepository> { FoodAllergenRepositoryImpl(get()) }
    single { GetFoodAllergensUseCase(get()) }
    single { FoodAllergenViewModel(get()) }
}

val dietaryTagModule = module {
    single { DietaryTagApi(get()) }
    single<DietaryTagRepository> { DietaryTagRepositoryImpl(get()) }
    single { GetDietaryTagsUseCase(get()) }
    single { DietaryTagViewModel(get()) }
}

val optionGroupModule = module {
    single { OptionGroupApi(get()) }
    single<OptionGroupRepository> { OptionGroupRepositoryImpl(get()) }
    single { GetOptionGroupsUseCase(get()) }
    single { GetOptionGroupByIdUseCase(get()) }
    single { OptionChoiceViewModel(get(), get(), get()) }
}

val optionChoiceModule = module {
    single { OptionChoiceApi(get()) }
    single<OptionChoiceRepository> { OptionChoiceRepositoryImpl(get()) }
    single { GetOptionChoicesUseCase(get()) }
    single { GetOptionChoiceByIdUseCase(get()) }
    single { GetOptionChoicesByGroupIdUseCase(get()) }
    single { OptionChoiceViewModel(get(), get(), get()) }
}

val proteinModule = module {
    single { ProteinApi(get()) }
    single<ProteinRepository> { ProteinRepositoryImpl(get()) }
    single { GetProteinsUseCase(get()) }
    single { GetProteinByIdUseCase(get()) }
    single { ProteinViewModel(get(), get()) }
}

val certificationTypeModule = module {
    single { CertificationTypeApi(get()) }
    single<CertificationTypeRepository> { CertificationTypeRepositoryImpl(get()) }
    single { GetCertificationTypesUseCase(get()) }
    single { GetCertificationTypeBySlugUseCase(get()) }
    single { CertificationTypeViewModel(get(), get()) }
}

val deliveryTimeWindowModule = module {
    single { DeliveryTimeWindowApi(get()) }
    single<DeliveryTimeWindowRepository> { DeliveryTimeWindowRepositoryImpl(get()) }
    single { GetDeliveryTimeWindowsUseCase(get()) }
    single { GetDeliveryTimeWindowsByChefIdUseCase(get()) }
    single { DeliveryTimeWindowViewModel(get(), get()) }
}

val notificationModule = module {
    single { NotificationApi(get()) }
    single<NotificationRepository> { NotificationRepositoryImpl(get()) }
    single { GetNotificationsUseCase(get()) }
    single { GetNotificationsByUserIdUseCase(get()) }
    single { NotificationViewModel(get(), get()) }
}

val sharedModule = module {
    includes(
        networkModule,
        authModule,
        chefProfileModule,
        orderModule,
        dishModule,
        chefServiceBookingModule,
        availableDishModule,
        certificationModule,
        profileModule,
        reviewModule,
        dishCategoryModule,
        serviceModule,
        serviceCategoryModule,
        stateModule,
        foodAllergenModule,
        dietaryTagModule,
        optionGroupModule,
        optionChoiceModule,
        proteinModule,
        certificationTypeModule,
        deliveryTimeWindowModule,
        notificationModule
    )
}