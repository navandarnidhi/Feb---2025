import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import HomePage from "./pages/HomePage";
import TaskDetails from "./pages/TaskDetails";
import CreateTask from "./pages/CreateTask";
import Navigation from './components/Navigation'
import { Container } from 'react-bootstrap'

function App() {
  return (
    <Router>
      <Navigation />
      <Container className="mt-4">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/tasks/:id" element={<TaskDetails />} />
          <Route path="/create" element={<CreateTask />} />
        </Routes>
      </Container>
    </Router>
  )
}

export default App