# Local Chefs Marketplace - Developer Documentation

## 🧭 Project Overview

Local Chefs is a marketplace platform that connects food enthusiasts with local chefs. The platform enables users to discover, book, and order from professional chefs in their area. Key features include:

- Chef discovery and profiles
- Menu and dish browsing
- Online ordering system
- Chef service bookings
- Reviews and ratings
- Real-time availability tracking
- Location-based search

### Target Audience
- Food enthusiasts looking for local culinary experiences
- Professional chefs seeking to monetize their skills
- Home cooks wanting to share their creations
- Event organizers looking for catering services

## ⚙️ Tech Stack

### Frontend
- **Framework**: React 18 with TypeScript
- **Build Tool**: Vite
- **Styling**: Tailwind CSS
- **State Management**: 
  - Zustand for global state
  - React Query for server state
- **Routing**: React Router v6
- **Form Handling**: React Hook Form with Zod validation
- **UI Components**: Custom components with Tailwind
- **Notifications**: Sonner toast notifications

### Backend
- **Database & Auth**: Supabase
- **Storage**: Supabase Storage
- **Real-time**: Supabase Realtime

## 📁 Folder Structure

```
src/
├── assets/         # Static assets and images
├── components/     # Reusable UI components
├── context/        # React context providers
├── hooks/          # Custom React hooks
├── integrations/   # Third-party integrations
├── interfaces/     # TypeScript interfaces
├── lib/           # Utility functions
├── pages/         # Page components
├── services/      # API and service functions
├── stores/        # Zustand stores
├── types/         # TypeScript type definitions
└── utils/         # Helper functions
```

## 🖥 UI Screens

### Public Pages
- **Home** (`/`): Landing page with featured chefs and how it works
- **Chefs** (`/chefs`): Browse and search for chefs
- **Chef Detail** (`/chefs/:id`): Individual chef profile and menu
- **Dish Detail** (`/dish/:id`): Individual dish details and ordering
- **Ready Dishes** (`/ready-dishes`): Currently available dishes
- **How It Works** (`/how-it-works`): Platform explanation
- **Become a Chef** (`/become-a-chef`): Chef registration
- **Auth** (`/auth`): Login and registration
- **FAQ** (`/faq`): Frequently asked questions
- **Terms & Privacy** (`/terms`, `/privacy`): Legal pages

### Protected Pages
- **Dashboard** (`/dashboard/*`): User dashboard
  - Profile management
  - Order history
  - Reviews
  - Chef profile (for chefs)
  - Menu management (for chefs)
  - Service bookings
  - Settings

### Admin Pages
- **Admin Panel** (`/admin/*`): Admin dashboard
  - User management
  - Chef verification
  - Order management
  - Content management
  - Settings

## 🔐 Authentication

### Supabase Auth Integration
- Email/password authentication
- Google OAuth integration
- Password reset functionality
- Session management with JWT

### Role-Based Access
- Buyer role: Can place orders and book services
- Chef role: Can manage menu and services
- Admin role: Platform management

### Protected Routes
- `RequireAuth`: HOC for protected user routes
- `RequireAdminAuth`: HOC for admin routes
- Role-based route protection in dashboard

## 🌐 Supabase Data Layer

### Database Tables
- `profiles`: User profiles
- `chef_profiles`: Chef-specific information
- `dishes`: Menu items
- `available_dishes`: Daily available dishes
- `orders`: Customer orders
- `reviews`: User reviews
- `certifications`: Chef certifications
- `services`: Chef services
- `bookings`: Service bookings

### Data Models

#### available_dishes
```typescript
interface AvailableDish {
  id: string;
  available_date: string;
  chef_id: string;
  created_at: string;
  dish_id: string;
  notes: string | null;
  quantity_available: number;
}
```

#### certification_type
```typescript
interface CertificationType {
  description: string | null;
  name: string;
  required: boolean;
  slug: string;
}
```

#### certifications
```typescript
interface Certification {
  certificate_number: string;
  chef_id: string;
  created_at: string;
  document_url: string;
  expires_at: string | null;
  id: string;
  issued_at: string;
  type: string;
  updated_at: string;
  verified: boolean;
}
```

#### chef_profiles
```typescript
interface ChefProfile {
  id: string;
  name: string | null;
  bio: string | null;
  address: string | null;
  city: string | null;
  state: string | null;
  zip_code: string;
  bg_image: string | null;
  cuisines: string[] | null;
  delivery_days: string[] | null;
  delivery_fee: number | null;
  delivery_radius_miles: number | null;
  facebook: string | null;
  free_delivery_above: number | null;
  instagram: string | null;
  is_active: boolean | null;
  is_agreement_accepted: boolean | null;
  is_delivery_available: boolean | null;
  is_featured: boolean | null;
  is_verified: boolean | null;
  latitude: number | null;
  longitude: number | null;
  location: unknown | null;
  min_order_notice_hours: number | null;
  minimum_order_amount: number | null;
  rating: number | null;
  review_count: number | null;
  telegram: string | null;
  type: string | null;
  whatsapp: string | null;
  created_at: string;
  updated_at: string;
}
```

#### chef_service_bookings
```typescript
interface ChefServiceBooking {
  id: string;
  address: string | null;
  agreed_to_deposit_terms: boolean;
  booking_date: string;
  booking_time: string;
  chef_id: string;
  client_id: string;
  created_at: string;
  custom_requests: string | null;
  deposit_amount: number | null;
  dietary_restrictions: string | null;
  email: string;
  event_type: string | null;
  full_name: string;
  instructions: string | null;
  number_of_guests: number;
  phone: string;
  service_id: string;
  status: string;
  updated_at: string;
  zipcode: string;
}
```

#### delivery_time_windows
```typescript
interface DeliveryTimeWindow {
  chef_id: string;
  created_at: string;
  end_time: string;
  id: string;
  start_time: string;
  updated_at: string;
}
```

#### dietary_tags
```typescript
interface DietaryTag {
  created_at: string;
  description: string;
  display_name: string;
  id: string;
  shortcode: string | null;
  tag_name: string;
  updated_at: string;
}
```

#### dish_category
```typescript
interface DishCategory {
  description: string | null;
  id: number;
  name: string;
  slug: string | null;
}
```

#### dishes
```typescript
interface Dish {
  id: string;
  chef_id: string;
  created_at: string | null;
  description: string | null;
  dietary_tags: string[] | null;
  dish_category_id: number | null;
  image_url: string | null;
  is_active: boolean | null;
  min_order_amount: number | null;
  name: string;
  price: number;
  updated_at: string | null;
}
```

#### food_allergens
```typescript
interface FoodAllergen {
  allergen_name: string;
  created_at: string;
  description: string;
  examples: string;
  id: string;
  updated_at: string;
}
```

#### notifications
```typescript
interface Notification {
  id: string;
  user_id: string;
  triggered_by: string | null;
  title: string;
  message: string;
  type: string | null;
  data: Json | null;
  is_read: boolean | null;
  email_sent: boolean | null;
  email_sent_at: string | null;
  actionlink: string | null;
  actiontext: string | null;
  created_at: string | null;
}
```

#### option_choices
```typescript
interface OptionChoice {
  additional_price: number | null;
  created_at: string | null;
  group_id: string;
  id: string;
  name: string;
  updated_at: string | null;
}
```

#### option_groups
```typescript
interface OptionGroup {
  created_at: string | null;
  dish_id: string;
  id: string;
  max_selections: number | null;
  min_selections: number | null;
  name: string;
  updated_at: string | null;
}
```

#### orders
```typescript
interface Order {
  id: string;
  buyer_id: string;
  chef_id: string;
  currency: string;
  delivery_address: string | null;
  delivery_fee: number | null;
  delivery_method: string;
  notes: string | null;
  ordered_at: string;
  payment_method: string;
  scheduled_for: string | null;
  special_instructions: string | null;
  status: OrderStatus;
  subtotal: number;
  tax: number;
  tip: number | null;
  total_amount: number;
  updated_at: string;
}
```

#### profiles
```typescript
interface Profile {
  id: string;
  allergies: string[] | null;
  avatar_url: string | null;
  city: string | null;
  created_at: string | null;
  deactivated_at: string | null;
  delivery_address: string | null;
  email: string | null;
  is_active: boolean | null;
  location: unknown | null;
  name: string | null;
  notification_preferences: Json | null;
  phone: string | null;
  role: string;
  state: string | null;
  updated_at: string | null;
  zip_code: string | null;
}
```

#### proteins
```typescript
interface Protein {
  created_at: string;
  id: string;
  name: string;
  updated_at: string;
}
```

#### reviews
```typescript
interface Review {
  id: string;
  chef_id: string;
  chef_reply: string | null;
  chef_reply_at: string | null;
  comment: string | null;
  created_at: string;
  order_id: string;
  rating: number;
  reviewer_id: string;
  tags: string[] | null;
}
```

#### service_categories
```typescript
interface ServiceCategory {
  display_name: string;
  slug: string;
}
```

#### services
```typescript
interface Service {
  id: string;
  chef_id: string;
  name: string;
  description: string;
  price: number;
  duration: number;
  category: string;
  created_at: string;
  updated_at: string;
}
```

#### states
```typescript
interface State {
  id: string;
  name: string;
  abbreviation: string;
}
```

### Data Access Patterns
```typescript
// Example queries
const { data, error } = await supabase
  .from('dishes')
  .select('*')
  .eq('chef_id', chefId);

// Insert
const { data, error } = await supabase
  .from('orders')
  .insert(orderData);

// Update
const { data, error } = await supabase
  .from('profiles')
  .update(profileData)
  .eq('id', userId);
```

## 📡 API Reference

### Auth Endpoints
```typescript
// Sign in
supabase.auth.signInWithPassword({ email, password })

// Sign up
supabase.auth.signUp({ email, password })

// Sign out
supabase.auth.signOut()
```

### Chef Endpoints
```typescript
// Fetch chefs
supabase.from('chef_profiles').select('*')

// Fetch chef details
supabase.from('chef_profiles').select('*').eq('id', chefId)

// Update chef profile
supabase.from('chef_profiles').update(data).eq('id', chefId)
```

### Order Endpoints
```typescript
// Create order
supabase.from('orders').insert(orderData)

// Fetch user orders
supabase.from('orders').select('*').eq('buyer_id', userId)

// Update order status
supabase.from('orders').update({ status }).eq('id', orderId)
```

## 🧠 State Management

### Zustand Stores
- `useCartStore`: Shopping cart management
- `useChefStore`: Chef data and listings
- `useDishStore`: Menu items management
- `useLocationChefStore`: Location-based chef search
- `useAvailableDishStore`: Available dishes tracking

### React Query Integration
```typescript
const { data, isLoading } = useQuery({
  queryKey: ['chefs'],
  queryFn: fetchChefs
});
```

## 🗺 Routing

### Route Structure
```typescript
<Routes>
  {/* Public routes */}
  <Route path="/" element={<Index />} />
  <Route path="/chefs" element={<Chefs />} />
  
  {/* Protected routes */}
  <Route element={<RequireAuth />}>
    <Route path="/dashboard/*" element={<DashboardRoutes />} />
  </Route>
  
  {/* Admin routes */}
  <Route path="/admin/*" element={<AdminRoutes />} />
</Routes>
```

## 🧪 Local Development Setup

1. Clone the repository
2. Install dependencies:
   ```bash
   npm install
   ```

3. Create `.env` file with required variables:
   ```
   VITE_SUPABASE_URL=your_supabase_url
   VITE_SUPABASE_ANON_KEY=your_supabase_anon_key
   ```

4. Start development server:
   ```bash
   npm run dev
   ```

## 🚀 Deployment

1. Build the project:
   ```bash
   npm run build
   ```

2. Deploy to Vercel:
   - Connect repository to Vercel
   - Configure environment variables
   - Deploy

## 🧩 Future Roadmap

### Planned Features
- Real-time order tracking
- In-app messaging
- Advanced search filters
- Mobile app development
- Payment integration
- Analytics dashboard

### Known Limitations
- Limited payment methods
- No real-time chat
- Basic search functionality
- Limited mobile optimization

### Design Improvements
- Enhanced mobile responsiveness
- Improved search UX
- Better order flow
- Enhanced chef profiles 
