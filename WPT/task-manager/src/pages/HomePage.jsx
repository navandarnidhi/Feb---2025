import { useState, useEffect } from 'react'
import { Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import TaskList from '../components/TaskList'
import SearchAndFilter from '../components/SearchAndFilter'

function HomePage() {
  const [tasks, setTasks] = useState([])
  const [searchTerm, setSearchTerm] = useState('')
  const [filterPriority, setFilterPriority] = useState('all')

  useEffect(() => {
    const savedTasks = JSON.parse(localStorage.getItem('tasks')) || []
    setTasks(savedTasks)
  }, [])

  const saveTasks = (updatedTasks) => {
    setTasks(updatedTasks)
    localStorage.setItem('tasks', JSON.stringify(updatedTasks))
  }

  const handleToggleComplete = (taskId) => {
    const updatedTasks = tasks.map(task =>
      task.id === taskId ? { ...task, completed: !task.completed } : task
    )
    saveTasks(updatedTasks)
  }

  const handleDelete = (taskId) => {
    const updatedTasks = tasks.filter(task => task.id !== taskId)
    saveTasks(updatedTasks)
  }

  const filteredTasks = tasks
    .filter(task => {
      const matchesSearch = task.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
        task.description.toLowerCase().includes(searchTerm.toLowerCase())
      const matchesPriority = filterPriority === 'all' || task.priority === filterPriority
      return matchesSearch && matchesPriority
    })

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h1>Tasks</h1>
        <Button as={Link} to="/create" variant="primary">
          Create Task
        </Button>
      </div>

      <SearchAndFilter
        searchTerm={searchTerm}
        onSearchChange={setSearchTerm}
        filterPriority={filterPriority}
        onFilterChange={setFilterPriority}
      />

      {filteredTasks.length > 0 ? (
        <TaskList
          tasks={filteredTasks}
          onToggleComplete={handleToggleComplete}
          onDelete={handleDelete}
        />
      ) : (
        <p>No tasks found. Create a new task to get started!</p>
      )}
    </div>
  )
}

export default HomePage