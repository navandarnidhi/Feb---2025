import { useParams, useNavigate } from 'react-router-dom'
import { Button } from 'react-bootstrap'
import TaskForm from '../components/TaskForm'
import { format } from 'date-fns'

function TaskDetails() {
  const { id } = useParams()
  const navigate = useNavigate()
  const tasks = JSON.parse(localStorage.getItem('tasks')) || []
  const task = tasks.find(t => t.id === id)

  if (!task) {
    return <div>Task not found</div>
  }

  const handleSubmit = (updatedTask) => {
    const updatedTasks = tasks.map(t => 
      t.id === id ? { ...updatedTask, id } : t
    )
    localStorage.setItem('tasks', JSON.stringify(updatedTasks))
    navigate('/')
  }

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h1>Task Details</h1>
        <Button variant="secondary" onClick={() => navigate('/')}>
          Back to List
        </Button>
      </div>

      <TaskForm 
        task={task}
        onSubmit={handleSubmit}
        onCancel={() => navigate('/')}
      />

      <div className="mt-4">
        <h5>Additional Information</h5>
        <p>Created: {format(new Date(), 'MMM dd, yyyy')}</p>
        <p>Status: {task.completed ? 'Completed' : 'Pending'}</p>
      </div>
    </div>
  )
}

export default TaskDetails