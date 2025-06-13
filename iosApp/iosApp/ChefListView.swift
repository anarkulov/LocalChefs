import SwiftUI
import Shared

struct ChefListView: View {
    @StateObject private var viewModel = ChefProfileViewModel.shared()

    var body: some View {
        VStack {
            if viewModel.state.isLoading {
                ProgressView()
                    .padding()
            } else if let error = viewModel.state.error {
                Text(error)
                    .foregroundColor(.red)
                    .padding()
            } else {
                List(viewModel.state.chefs, id: \ .id) { chef in
                    VStack(alignment: .leading, spacing: 4) {
                        Text(chef.name ?? "Unnamed Chef")
                            .font(.headline)
                        Text(chef.city ?? "Unknown City")
                            .font(.subheadline)
                        Text(chef.cuisines?.joined(separator: ", ") ?? "No cuisines listed")
                            .font(.footnote)
                            .foregroundColor(.secondary)
                    }
                    .padding(.vertical, 4)
                }
            }
        }
        .onAppear {
            viewModel.loadChefs()
        }
        .navigationTitle("Chefs")
    }
} 