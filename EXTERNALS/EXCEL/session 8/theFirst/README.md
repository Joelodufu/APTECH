# theFirst

A TypeScript-based Express API with MongoDB, Mongoose, clean architecture, Zod validation, tsyringe DI, and Jest testing.

## Setup

1. Ensure MongoDB is running locally or update `.env` with your MongoDB URI.
2. Install dependencies:
   ```bash
   npm install
   ```
3. Run in development mode:
   ```bash
   npm run dev
   ```
4. Build for production:
   ```bash
   npm run build
   npm start
   ```
5. Run tests:
   ```bash
   npm test
   ```

## Testing



## Structure

- `Core/`: Shared utilities (config, error, result).
- `Features/`: Feature-specific modules ().
  - `domain/`: Business logic (entities, use cases, repositories).
  - `data/`: Data access (models, data sources, repositories).
  - `delivery/`: HTTP layer (controllers, middleware).
  - `container.ts`: DI container setup.
- `Server/`: Application entry point.
- `__tests__/`: Jest tests for features.

## Notes

- Uses `tsyringe` for dependency injection and `zod` for validation.
- Run `npm test` to execute unit and integration tests.
- Ensure MongoDB is running for integration tests.