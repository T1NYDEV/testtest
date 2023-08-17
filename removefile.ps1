function deletefile 
{
    [CmdletBinding()]
    param (
        [parameter(Position=0,Mandatory=$False)]
        [string]$filepath
    )
    Remove-Item $filepath
}
