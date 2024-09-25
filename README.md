# Trend Bar Service

## Terminology

- **Symbol**: A currency pair (e.g. EURUSD, EURJPY).
- **Quote**: A price update for a particular symbol at a specific moment in time. It contains:
  - new price
  - symbol
  - timestamp
- **Trend Bar (TB)**: Also known as a candlestick, it is aggregated quote data for a particular symbol within a given trend bar period. For more details, see: [OHLC chart](https://en.wikipedia.org/wiki/Open-high-low-close_chart) or [candlestick chart](https://en.wikipedia.org/wiki/Candlestick_chart). A TB contains the following parameters:
  - **Open price**: The price at the beginning of a trend bar period for the given symbol.
  - **Close price**: The price from the last received quote in the trend bar period.
  - **High price**: The maximum price during the period.
  - **Low price**: The minimum price during the period.
  - **Trend bar period**: The time interval during which quotes are accumulated (e.g. M1 - one minute, H1 - one hour, D1 - one day, etc.).
  - **Timestamp**: The time at which the trend bar period started.
  
  Trend bars always start at the beginning of a time period. For minutely TBs, they start at `00:00:00`, `00:01:00`, and so on. For hourly TBs, they start at `00:00:00`, `01:00:00`, and so on. Note that quote time and server time may differ, and TBs are based on quotes.

- **Completed TB**: A TB where the time interval is over. For example, for an M1 TB, completed TBs are those created before or at the start of the previous minute.
- **TB History**: A set of completed TBs where the start time is within a specific period of time.

## Task Description

Assume there are three types of trend bars:
- M1 (minutely)
- H1 (hourly)
- D1 (daily)

### Trend Bar Service Requirements

1. **Building Trend Bars**:
   - The service should build TBs based on received quotes.
   - It should maintain a set of current trend bars, updating them with each received quote.
   - Once a trend bar period is over, it should persist the TB to storage.

2. **Providing Trend Bar History**:
   - The service should return a set of TBs based on the requested symbol name, trend bar period, and a time range (from timestamp and to timestamp).
   - If the "to" timestamp is omitted, the service should return all TBs from the specified "from" timestamp until now.

## General Requirements

- The source code must be **compilable**. If it does not compile, the task will not be considered completed.
- Source code should be covered with **unit tests** using either **JUnit** or **TestNG**.
- Code should follow **clean code principles** (as described in the *Clean Code* book) and be easy to understand. Well-structured code should document itself.
- The code must be formatted according to **standard Java Code Style**.
- The project should follow a **Maven-compliant** structure, with a `pom.xml` file describing the project and its dependencies in the root directory.

### Limitations and Clarifications

- Keep the solution **simple**.
- Avoid using third-party frameworks except for:
  - **Dependency Injection** frameworks (e.g., Spring, Guice).
  - **Mocking** frameworks (e.g., Mockito, JMock).
  
- **Dependency Injection** is encouraged and should be used where applicable.
- Use **Test-Driven Development (TDD)** to implement this task, ensuring clean and concise code.
- TB history includes **completed trend bars only**.
- TB storage can be **in-memory** (not an in-memory database, but a data structure in the Java heap).
- Quotes arrive in **one thread**, while history requests are made in **another thread**.
- Quotes are received in **natural order**, meaning each new quote has a timestamp later than the previous one.
- The **number of quotes per minute** can be very high.
- A trend bar should be updated **as soon as possible** after receiving a quote.
- **Time zones** are not relevant for this task; Unix time in milliseconds can be used.
- The trend bar service is a **module** within a larger system, not a standalone application. There is no need to expose this service via web services or create a UI.

### Bonuses

- The TB service should process received quotes **asynchronously** (i.e., not process the received quote in the same thread, but store it internally for further processing by another thread).
- It would be beneficial to have **trivial implementations** of a quotes provider to use in integration tests.

