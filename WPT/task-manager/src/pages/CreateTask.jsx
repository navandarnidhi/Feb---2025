import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import TaskForm from '../components/TaskForm'
import { v4 as uuidv4 } from 'uuid'

function CreateTask() {
  const navigate = useNavigate()
  const [tasks, setTasks] = useState(
    JSON.parse(localStorage.getItem('tasks')) || []
  )

  const handleSubmit = (newTask) => {
    const updatedTasks = [...tasks, { ...newTask, id: uuidv4() }]
    setTasks(updatedTasks)
    localStorage.setItem('tasks', JSON.stringify(updatedTasks))
    navigate('/')
  }

  return (
    <div>
      <h1 className="mb-4">Create New Task</h1>
      <TaskForm onSubmit={handleSubmit} onCancel={() => navigate('/')} />
    </div>
  )
}

export default CreateTask