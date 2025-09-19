# Mio - POS System

### Repo Information
-  This is a simulator POS System of the ’IL Mio’ Pizza Store
-  IL Mio POS is a pos system support order food, table reservation, employee timekeeping, violations tracking, salary calculation and support for export salary, timekeeping, violations sheet to Excel.
-  Owned the end-to-end sales flow: table reservation → order ticketing → kitchen printouts → invoicing → payment, with AJAX updates on the frontend and REST services on the backend.
-  Built table operations (reserve, occupy, move/merge/split tables) and kitchen tickets (auto print/generate on item add), ensuring consistent totals and auditability.
  
### Environment
-  Java: 21.0.6
-  Jdk: 21.0.6

### Repositories
- Frontend: [front-end repo](https://github.com/callmekz25/restaurant-pos-system)
- Backend: current repository

### Tech Stack
- Backend: Java Spring Boot, Java
- Auth: Spring Security, JWT
- Database: PostgreSQL
- Frontend: ReactJS, Typescript, Tailwindcss, shadcnUI
- Optional: mapstruct

### Features
- Role-based user permissions
- Reserve a table with customer details
- Add, edit, delete dishes in a customer's order and payment an order
- Timekeeping and penalizing employees for violations on each working day
- Calculate salaries based on working days, violations and holidays
- Export salary, timekeeping and violation reports to Excel
### Demo
