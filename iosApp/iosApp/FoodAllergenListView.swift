import SwiftUI
import Shared

struct FoodAllergenListView: View {
    @StateObject private var viewModel = FoodAllergenViewModel.shared()
    
    var body: some View {
        Group {
            if viewModel.state.isLoading {
                ProgressView()
                    .padding()
            } else if let error = viewModel.state.error {
                Text(error)
                    .foregroundColor(.red)
                    .padding()
            } else {
                List(viewModel.state.foodAllergens, id: \.id) { allergen in
                    VStack(alignment: .leading, spacing: 4) {
                        Text(allergen.allergenName)
                            .font(.headline)
                        Text(allergen.description)
                            .font(.subheadline)
                        if !allergen.examples.isEmpty {
                            Text("Examples: \(allergen.examples)")
                                .font(.footnote)
                                .foregroundColor(.secondary)
                        }
                    }
                    .padding(.vertical, 4)
                }
            }
        }
        .onAppear {
            viewModel.loadFoodAllergens()
        }
        .navigationTitle("Food Allergens")
    }
} 