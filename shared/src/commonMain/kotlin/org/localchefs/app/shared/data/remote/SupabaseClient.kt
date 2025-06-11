package org.localchefs.app.shared.data.remote

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    private const val SUPABASE_URL = "https://nelqzxlkkwvvnlucryup.supabase.co"
    private const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5lbHF6eGxra3d2dm5sdWNyeXVwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDU4ODUzMTYsImV4cCI6MjA2MTQ2MTMxNn0.a6Sd1x9jj75c28R-gOQ2LN1R155CWm97FXVaA9Hz5HA"

    val client: SupabaseClient = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(Auth)
        install(Postgrest)
    }
} 